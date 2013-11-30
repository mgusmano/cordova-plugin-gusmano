package org.apache.cordova.gusmano;

import java.lang.reflect.Method;

import org.apache.cordova.CallbackContext;
//import org.apache.cordova.CordovaActivity;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.R;
//import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
//import android.app.Activity;
//import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
//import android.net.Uri;
//import android.os.Bundle;
//import android.provider.MediaStore.Audio;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.View;
//import android.widget.EditText;

//import com.gusmano.TouchApp4

//import android.content.Context;
//import android.content.IntentFilter;
import android.provider.MediaStore.Audio;
//import android.provider.Settings;
//import android.telephony.TelephonyManager;
//import android.util.Log;
import android.telephony.SmsManager;

public class Gusmano extends CordovaPlugin {
    public static final String TAG = "Echo";

    //public static String cordovaVersion = "dev";              // Cordova version
    //public static String platform = "Android";                  // Echo OS
    //public static String uuid;                                  // Echo UUID

    //BroadcastReceiver telephonyReceiver = null;

    public Gusmano() {
    }

 
    /**
     * Sets the context of the Command. This can then be used to do things like
     * get file paths associated with the Activity.
     *
     * @param cordova The context of the main Activity.
     * @param webView The CordovaWebView Cordova is running in.
     */
    
    
    @SuppressWarnings("deprecation")
	public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
    }
   
   
    @SuppressWarnings("deprecation")
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
 
    	if (action.equals("createEcho")) {
            JSONObject arg_object = args.getJSONObject(0);
            //arg_object.getString("title")
            JSONObject r = new JSONObject();
            r.put("echoVal", arg_object.getString("echoVal"));
            callbackContext.success(r);                
            return true;    	
    	} 
    	else if (action.equals("sendNotification")) {
		    Intent intent = new Intent(cordova.getActivity().getApplicationContext(),cordova.getClass());
		    intent.putExtra("page", "Notification");
		    PendingIntent pIntent = PendingIntent.getActivity(cordova.getActivity().getApplicationContext(), 0, intent, 0);		    
    		Notification n2  = new Notification.Builder(cordova.getActivity().getApplicationContext())
    		        .setContentTitle("This is Notification 1")
    		        .setContentText("Subject")
    		        .setSmallIcon(R.drawable.ic_menu_share)
    		        .setContentIntent(pIntent)
    		        .setAutoCancel(true)
    		        .addAction(R.drawable.ic_menu_share, "Call", pIntent)
    		        .addAction(R.drawable.ic_menu_share, "More", pIntent)
    		        .addAction(R.drawable.ic_menu_share, "And more", pIntent).build();
    		NotificationManager notificationManager = (NotificationManager)cordova.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
    		int unique_id1 = 145559;
    		notificationManager.notify(0, n2); 	           
            
            NotificationManager nm = (NotificationManager)cordova.getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
            int unique_id = 145558;
		    Intent nintent = new Intent(cordova.getActivity().getApplicationContext(),cordova.getClass());
		    nintent.putExtra("page", "Notification");
            //nintent.setClass(this, TestActivity.class);
            PendingIntent pin = PendingIntent.getActivity(cordova.getActivity().getApplicationContext(), 0, nintent, 0);
            String title = "This is Notification 2";
            String body = "his is a notification 2";
            Notification n = new Notification(R.drawable.ic_menu_slideshow, body, System.currentTimeMillis());
            n.contentIntent = pin;
		    n.sound = Uri.withAppendedPath(Audio.Media.EXTERNAL_CONTENT_URI, "4"); //using sound
		    n.vibrate = new long[]{0,100,200,300}; //vibrate (don't forget to add permission)
		    n.ledARGB = 0xFFf3f3f3;
		    n.ledOnMS = 100;
		    n.ledOffMS = 100;
		    n.flags |= Notification.FLAG_SHOW_LIGHTS;
		    n.flags |= Notification.FLAG_AUTO_CANCEL;            
            n.setLatestEventInfo(cordova.getActivity().getApplicationContext(), title, body, pin);
            n.defaults = Notification.DEFAULT_ALL;
            nm.notify(0, n);    		
            JSONObject success = new JSONObject();
            success.put("return", "true");
            callbackContext.success(success);
    	} 
    	else if (action.equals("sayHi")) {
    		Method method;
    		try {
    			method = cordova.getClass().getMethod("sayHi", new Class[]{String.class});
    			method.invoke(cordova, "theparam");
    		} catch (Exception e) {
    			e.printStackTrace();
    		}  
            JSONObject success = new JSONObject();
            success.put("return", "true");
            callbackContext.success(success);
    	} 
    	else if (action.equals("showSplash")) {
    		this.webView.postMessage("splashscreen", "show");    		
		}    	
		else if (action.equals("sendSMS")) {
            JSONObject arg_object = args.getJSONObject(0);
			String phoneNumber = arg_object.getString("phoneNumber");
			String message = arg_object.getString("message");
//	        Uri smsUri = Uri.parse("smsto:1-" + phoneNumber);
//	        Intent sendIntent = new Intent(Intent.ACTION_SENDTO, smsUri);
//	        sendIntent.putExtra("sms_body", message);
//	        //sendIntent.setType("vnd.android-dir/mms-sms");
//	        cordova.getActivity().startActivity(sendIntent);	
	        SmsManager smsManager = SmsManager.getDefault();
	        smsManager.sendTextMessage("+1-" + phoneNumber, null, message, null, null);	        
		}    	
		else if (action.equals("makeCall")) {
             JSONObject arg_object = args.getJSONObject(0);
			 String phoneNumber = arg_object.getString("phoneNumber");
			 String uri = "tel:" + phoneNumber.trim() ;
			 Intent intent = new Intent(Intent.ACTION_CALL);
			 intent.setData(Uri.parse(uri));
			 cordova.getActivity().startActivity(intent);	
		}    	
		else if (action.equals("sayHi")) {
		}    	
		else if (action.equals("sayHi")) {
		}    	
		else if (action.equals("sayHi")) {
		}    	

    	
    	
    	
    	else {
    	    return false;
    	}

    
//        if (action.equals("echo")) {
//            JSONObject arg_object = args.getJSONObject(0);
//            //arg_object.getString("title")
//            JSONObject r = new JSONObject();
//            r.put("test", arg_object.getString("theVal"));
//            r.put("test2", "src"); 
//
//            //Context context=this.cordova.getActivity().getApplicationContext();
//
//          
//            
//  
//            
//            callbackContext.success(r);
//        }
//        else {
//            return false;
//        }
       return true;
    }
 
}
