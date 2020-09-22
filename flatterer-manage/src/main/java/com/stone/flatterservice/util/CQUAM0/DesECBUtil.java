package com.stone.flatterservice.util.CQUAM0;

import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * DES ECB对称加密 解密
 */
public class DesECBUtil {



    /**
     * 加密数据
     * @param str
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encrypt(String str, String key)
            throws Exception {

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] byteMi = cipher.doFinal(str.getBytes());
        return byteMi;

    }

    /**
     * 解密数据
     * @param bytes
     * @param key
     * @return
     * @throws Exception
     */
    public static String decrypt(byte[] bytes, String key)
            throws Exception {

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        DESKeySpec desKeySpec = new DESKeySpec(key.getBytes());
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] byteMi = cipher.doFinal(bytes);
        return new String(byteMi);

    }

    /**
     * 测试方法
     * @param args
     * @throws Exception
     */
//    public static void main(String[] args) throws Exception {
//        String clearText = "EsUyx2peY5T5WBe2ckCEfHme6O3Tvy5HzyB5pg9/V2Z0/t0nx9qsAfv10h0ccOCHaq1jNI70cb2FpMHdoJ50Fu7ZDuZIwo5XBMi006cdcA34363PLWSjAzPbUw5yCtswtjBg60sZLBoXCsV3zWgwmWT4yldRaz/+oeuAsP22qy1OvpTuB3e/q+xiV8vzwGPuWb8+ET+ZhbBmXMo1FmnSe8aSjbAojHIb4lR+b5OqgCHK3P2ZtB/gSQ==";
//        String key = UUID.randomUUID().toString().replaceAll("-", "");//这里的数据长度必须为8的倍数
//        
//         key = SignKey.accountDistributeKey;
//        System.out.println("明文："+clearText+"\n密钥："+key);
//
//
//        //加密
//        clearText = Base64Util.encode(encrypt(clearText, key));
//        System.out.println("加密后："+clearText);
//		String sign="7wnGpZhWTSo3V3wYFJ1Pot67tuvhgLkwRHNozqaXBi9U+cYp4iHX0fkd09P5OyNd2wP7smZkjzHIFGm0Ulrna4HP+2gkzFISMdxWNrDvOikstR3pHCxWh3MlMmkaXEWG08Zn0v/gUCfqC8nZXXiI7vpEIgW0AqJmzAaP9R5XcMmX+AOhSrIAYuu9uGh1dgf87RuOppL4/J9VX1fY5WTBBYOHig46sGgPGvMJNVLCkzxfInmSXgsIqUDXqkAxtwuFVst31fEu4HDpDc5jrpn7JZiY8+ajw757exXMxgunNcZA/q1xOr0mDVCXFiB8/syAZ5s56TqFNg2eayElnneWF6GKcIMrr3roWVwURpKFyCuNjLjR8KPP1VGolXsbVk3M/R+gXCny6gNAQ/5Lnkwk16MZfWjYhFXL5bQAoA4nYzoH+tlqTVzhSXHCSIYsC3HoQryv6rjVfCD0FCV7xstqdhBipS+0yYxN9HRu4geH6O+pANFMLkqQsu8VMh+/FcFlGMZZ8jMYR865vOWg8gIMWg==";
//
//        //解密
//		String decryptText = decrypt(Base64Util.decode(sign),key);
//        System.out.println("解密后："+decryptText);
//
//        //密钥
//        /*String sign = "166377c38df04afcad3e85eea45e535f";
//        String mw = "CRMadmin";
//        mw = Base64Util.encode(encrypt(mw, sign));
//        System.out.println("加密："+mw);*/
//
//
//
//
//    }
}