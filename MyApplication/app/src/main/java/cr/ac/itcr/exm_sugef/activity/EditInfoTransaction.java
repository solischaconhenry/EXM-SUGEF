package cr.ac.itcr.exm_sugef.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import cr.ac.itcr.exm_sugef.R;
import cr.ac.itcr.exm_sugef.app.EndPoints;
import cr.ac.itcr.exm_sugef.app.MyApplication;

public class EditInfoTransaction extends AppCompatActivity {
    private static final String TAG = EditText.class.getSimpleName();
    private EditText txtType, txtDate,txtRode;
    private String _id, active, user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_info_transaction);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Edit Transaction");

        txtType = (EditText)findViewById(R.id.txtEditType);
        txtDate = (EditText)findViewById(R.id.txtEditDate);
        txtRode = (EditText)findViewById(R.id.txtEditRode);

        Intent intent = getIntent();
        txtType.setText(intent.getStringExtra("type"));
        txtDate.setText(intent.getStringExtra("date"));
        txtRode.setText(intent.getStringExtra("rode"));
        _id = intent.getStringExtra("_id");
        user = intent.getStringExtra("user");
        active = intent.getStringExtra("active");


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String endPoint = EndPoints.EDIT_TRANSACTION.replace(":idTransaction", _id);

                    Log.e(TAG, "endpoint: " + endPoint);

                    StringRequest strReq = new StringRequest(Request.Method.PUT,
                            endPoint, new Response.Listener<String>() {

                        @Override
                        public void onResponse(String response) {

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            NetworkResponse networkResponse = error.networkResponse;
                            Log.e(TAG, "VolleyLis error: " + error.getMessage() + ", code: " + networkResponse);
                            Toast.makeText(getApplicationContext(), "VolleyLis error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("type", txtType.getText().toString());
                            params.put("rode", txtRode.getText().toString());
                            params.put("date",txtDate.getText().toString());
                            params.put("idTransaction",_id);

                            Log.e(TAG, "params: " + params.toString());
                            return params;
                        }
                    };

                    //Adding request to request queue
                    MyApplication.getInstance().addToRequestQueue(strReq);

                }
            });
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
