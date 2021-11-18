package au.edu.unsw.infs3634.unswgamifiedlearningapp;

import androidx.appcompat.app.AppCompatActivity;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvLoginError;
    private TextView tvWea;

    private String username1 = "Admin";
    private String password1 = "12345";

    boolean isValid = false;
    private SqlUtils sqlUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqlUtils = SqlUtils.getInstance();
        //getSupportActionBar().setTitle("Think Green");

        // Idea for login screen taken from:
        // Title: LoginApplication source code
        // Author: Professor DK
        // Date: 25/5/2020
        // Availability: https://www.youtube.com/watch?v=LCrhddpsgKU&ab_channel=ProfessorDK

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);

        etUsername.addTextChangedListener(loginTextWatcher);
        etPassword.addTextChangedListener(loginTextWatcher);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setEnabled(false);

        tvWea = findViewById(R.id.tv_wea);

        tvLoginError = (TextView) findViewById(R.id.tvLoginError);

        // Idea for custom button design taken from:
        // Title: CustomButtons source code
        // Author: Stevdza-San
        // Date: 10/10/2018
        // Availability: https://www.youtube.com/watch?v=nlPtfncjOWA&ab_channel=Stevdza-San

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                isValid = validate(username, password);

                if(!isValid){
                    tvLoginError.setText("Username or password is incorrect, please try again");
                }else{
                    SPUtils.put("userName",username);
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
        });

        SharedPreferences setting = getSharedPreferences("qidongcishu", 0);
        boolean first = setting.getBoolean("FIRST", true);
        if (first) {// Jump to the welcome page for the first time
            setting.edit().putBoolean("FIRST", false).commit();
            importSheet();
        } else {//If it is the second start, jump directly to the main page

        }

        getWeather();
    }


    // Idea for using textWatcher to disable button when editText is empty taken from:
    // Title: textWatcherExample source code
    // Author: Coding in Flow
    // Date: 7/4/2018
    // Availability: https://www.youtube.com/watch?v=Vy_4sZ6JVHM&ab_channel=CodinginFlow
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String usernameInput = etUsername.getText().toString();
            String passwordInput = etPassword.getText().toString();
            btnLogin.setEnabled(!usernameInput.isEmpty() && !passwordInput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };
    private boolean validate(String user, String pass){
        if(user.equals(username1) && pass.equals(password1)){
            return true;
        }
        return false;
    }

    private void importSheet() {
        try {
            // 1
            InputStream is = getResources().getAssets().open("green.xls");
            // 2
            Workbook book = Workbook.getWorkbook(is);
            // 3
            Sheet sheet = book.getSheet(0);
            // 4
            for (int j = 0; j < sheet.getRows(); ++j) {
                Quesstion w = new Quesstion();
                w.setTitle(sheet.getCell(0, j).getContents());
                w.setAnswer(sheet.getCell(1, j).getContents());
                w.setAnswer1(sheet.getCell(2, j).getContents());
                w.setAnswer2(sheet.getCell(3, j).getContents());
                w.setAnswer3(sheet.getCell(4, j).getContents());
                w.setAnswer4(sheet.getCell(5, j).getContents());
                w.setStatus(Integer.parseInt(sheet.getCell(6,j).getContents()));
                //Log.e("xxxxx","-->"+sheet.getCell(0, j).getContents()+"-->"+sheet.getCell(1, j).getContents());
                sqlUtils.getDb().save(w);
            }
            book.close();
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }

    }

    private void getWeather(){
        WeatherRequestManager.getApiInterface().getWea("v1").enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if(response.isSuccessful()){
                    try {
                        if(response.body()!=null &&response.body().getWeas()!=null&&response.body().getWeas().size()>0){
                            Log.e("xxxx","天气："+response.body().getWeas().get(0).getWea());
                            tvWea.setText(response.body().getWeas().get(0).getWea());
                        }
                        Log.e("xxxx",""+response.body().toString());
                    }catch (Exception ex){}
                }else{
                    try {
                        Log.e("xxxx","sds:"+response.message());
                    }catch (Exception ex){
                    }

                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.e("xxxx","error："+t.getMessage());
            }
        });
    }

}