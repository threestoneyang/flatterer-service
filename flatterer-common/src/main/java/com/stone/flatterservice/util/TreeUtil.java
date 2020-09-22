package com.stone.flatterservice.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stone.flatterservice.vo.TreeNode;

/**
 * Created by 王家明 on 2017/6/12.
 */
public class TreeUtil {
	/**
	 * 两层循环实现建树
	 * 
	 * @param treeNodes
	 *            传入的树节点列表
	 * @return
	 */
	public static <T extends TreeNode> List<T> bulid(List<T> treeNodes, Object root) {

		List<T> trees = new ArrayList<T>();

		for (T treeNode : treeNodes) {

			if (root.equals(treeNode.getParentId())) {
				trees.add(treeNode);
			}

			for (T it : treeNodes) {
				if (it.getParentId() == treeNode.getId()) {
					if (treeNode.getChildren() == null) {
						treeNode.setChildren(new ArrayList<TreeNode>());
					}
					treeNode.add(it);
				}
			}
		}
		return trees;
	}

	/**
	 * 使用递归方法建树
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static <T extends TreeNode> List<T> buildByRecursive(List<T> treeNodes, Object root) {
		List<T> trees = new ArrayList<T>();
		for (T treeNode : treeNodes) {
			if (root.equals(treeNode.getParentId())) {
				trees.add(findChildren(treeNode, treeNodes));
			}
		}
		return trees;
	}

	/**
	 * 递归查找子节点
	 * 
	 * @param treeNodes
	 * @return
	 */
	public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
		for (T it : treeNodes) {
			if (treeNode.getId() == it.getParentId()) {
				if (treeNode.getChildren() == null) {
					treeNode.setChildren(new ArrayList<TreeNode>());
				}
				treeNode.add(findChildren(it, treeNodes));
			}
		}
		return treeNode;
	}

	/**
	 * 生成树型结构数据
	 * 
	 * @param nodeList
	 * @return
	 */
	public static List<Map<String, Object>> createTreeDataList(List<Map<String, Object>> nodeList) {
		// 所有数据的实体类
		Map<String, Map<String, Object>> treeMap = new HashMap<String, Map<String, Object>>();
		// 父类id，得到全部的子类id
		Map<String, List<String>> pidMap = new HashMap<String, List<String>>();
		for (Map<String, Object> map : nodeList) {
			List<Map<String, Object>> childrenList = new ArrayList<Map<String, Object>>();
			map.put("children", childrenList);
			treeMap.put(map.get("id").toString(), map);
			// 1、拿到顶层节点
			Object pId = map.get("parent_id");
			String pid = null;
			if (!"0".equals(pId.toString())) {
				pid = pId.toString();
			} else {
				continue;
			}
			// 2、通过父类id能拿到全部子类的id
			if (pidMap.get(pid) == null) {
				List<String> list = new ArrayList<String>();
				list.add(map.get("id").toString());
				pidMap.put(pId.toString(), list);
			} else {
				List<String> list = pidMap.get(pId.toString());
				list.add(map.get("id").toString());
			}
		}
		// 加入没有子集的项
		for (Map<String, Object> map : nodeList) {
			String id = map.get("id").toString();
			boolean isdo = true;
			for (Map<String, Object> flagmap : nodeList) {
				String parentId = "";
				if (null != flagmap.get("parent_id")) {
					parentId = flagmap.get("parent_id").toString();
				}
				if (id.equals(parentId)) {
					isdo = false;
					break;
				}
			}
			if (isdo) {
				List<String> list = new ArrayList<String>();
				pidMap.put(id, list);
			}
		}
		List<String> fatherId = new ArrayList<String>(pidMap.keySet());
		int size = fatherId.size();
		// 递归组合成树形结构数据
		List<Map<String, Object>> dataList = getTree(fatherId, nodeList.get(0).get("id").toString(), treeMap, pidMap,
				new ArrayList<Map<String, Object>>(), size);
		return dataList;
	}

	/**
	 * 递归组合数据
	 * 
	 * @param fatherId
	 * @param id
	 * @param treeMap
	 * @param pidMap
	 * @param result
	 * @param size
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, Object>> getTree(List<String> fatherId, String id,
			Map<String, Map<String, Object>> treeMap, Map<String, List<String>> pidMap,
			List<Map<String, Object>> result, int size) {
		// 先去获取当前对象，在把子节点的treeset到children里面去。
		Map<String, Object> tree = treeMap.get(id); // 这个tree就是实体类！
		if (tree != null) { // 正常情况下不会为空，出现为空的情况都是因为有脏数据造成的
			Object parentId = tree.get("parent_id");
			List<Map<String, Object>> childrenList = (List<Map<String, Object>>) tree.get("children");
			if (parentId == null || "0".equals(parentId.toString())) {
				// 我这里应该保存的是一级对象，子对象都在一级对象里面
				if (!result.contains(tree)) {
					result.add(tree);
				}
			}
			List<String> childList = pidMap.get(id);
			if (childList != null) {
				// 以下遍历是为了找出子节点
				for (String c : childList) {
					Map<String, Object> childTree = treeMap.get(c);
					String pid = childTree.get("parent_id").toString();
					if (id.equals(pid)) {
						if (!childrenList.contains(childTree)) {
							childrenList.add(childTree);
						}
					}
				}
			}
			if (null != childrenList && childrenList.size() == 0) {
				// 判断如果没有子节点就去掉children属性
				tree.remove("children");
			}
		}
		if (size <= 0) {// 结束
			return result;
		}
		int ss = size - 1;
		result = getTree(fatherId, fatherId.get(ss), treeMap, pidMap, result, ss);
		return result;
	}
}
