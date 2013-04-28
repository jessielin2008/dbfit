package dbfit.util.crypto;

import dbfit.util.crypto.CryptoKeyService;
import dbfit.util.crypto.CryptoService;

import java.security.Key;

public class CryptoServiceFactory {

    private static CryptoService cryptoServiceInstance = null;
    private static CryptoKeyService keyService = null; // for overwriting default

    public static void setCryptoService(CryptoService svc) {
        cryptoServiceInstance = svc;
    }

    public static void setKeyService(CryptoKeyService keySvc) {
        keyService = keySvc;
    }

    private static CryptoKeyService getKeyService() {
        if (null != keyService) {
            return keyService;
        } else {
            return CryptoAdmin.getCryptoKeyServiceFactory().getKeyService();
        }
    }

    private static void initCryptoService() {
        Key key = getKeyService().getKey();
        setCryptoService(createAESCryptoService(key));
    }

    public static CryptoService getCryptoService() {
        if (cryptoServiceInstance == null) {
            initCryptoService();
        }

        return cryptoServiceInstance;
    }

    public static AESCryptoService createAESCryptoService(Key key) {
        return new AESCryptoService(key);
    }
}

