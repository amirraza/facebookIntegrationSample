package com.home.amirraza.facebookloginusingfragmentslidenerd;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by AmirRaza on 6/28/2015.
 */
public class ApplicationClass extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        try {

            //generating HashKey
            PackageInfo info = getPackageManager().getPackageInfo(
                    "com.home.amirraza.facebookloginusingfragmentslidenerd",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }

    }
}
