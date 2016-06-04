package cr.ac.itcr.exm_sugef.helper;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import cr.ac.itcr.exm_sugef.model.User;

/**
 * Created by usuario on 3/6/2016.
 */
public class MyPreferenceManager {
    private String TAG = MyPreferenceManager.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Sharedpref file name
    private static final String PREF_NAME = "sugef";

    // All Shared Preferences Keys
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_NAME = "user_name";
    private static final String KEY_USER_EMAIL = "user_email";
    private static final String KEY_USER_PASSWORD = "user_pass";

    // Constructor
    public MyPreferenceManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    public void storeUser(User user) {
        editor.putString(KEY_USER_ID, user.get_id());
        editor.putString(KEY_USER_NAME, user.getUser());
        editor.putString(KEY_USER_EMAIL, user.getEmail());
        editor.putString(KEY_USER_PASSWORD, user.getPassword());
        editor.commit();

        Log.e(TAG, "User is stored in shared preferences. " + user.getUser() + ", " + user.getEmail());
    }

    public User getUser() {
        if (pref.getString(KEY_USER_ID, null) != null) {
            String id, name, email, password;
            id = pref.getString(KEY_USER_ID, null);
            name = pref.getString(KEY_USER_NAME, null);
            email = pref.getString(KEY_USER_EMAIL, null);
            password = pref.getString(KEY_USER_PASSWORD, null);

            User user = new User(id, name, email, password);
            return user;
        }
        return null;
    }



    public void clear() {
        editor.clear();
        editor.commit();
    }
}
