package com.example.tcc2.ui.login;

import android.annotation.SuppressLint;
import android.app.Activity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tcc2.MainActivity;
import com.example.tcc2.R;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ProgressDialog load;
    EditText usernameEditText = null;
    EditText passwordEditText = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginViewModel = ViewModelProviders.of(this, new LoginViewModelFactory())
                .get(LoginViewModel.class);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        final Button loginButton = findViewById(R.id.login);
        final ProgressBar loadingProgressBar = findViewById(R.id.loading);
        final GetJson download = new GetJson();

        loginViewModel.getLoginFormState().observe(this, new Observer<LoginFormState>() {
            @Override
            public void onChanged(@Nullable LoginFormState loginFormState) {
                if (loginFormState == null) {
                    return;
                }
                loginButton.setEnabled(loginFormState.isDataValid());
                if (loginFormState.getUsernameError() != null) {
                    usernameEditText.setError(getString(loginFormState.getUsernameError()));
                }
                if (loginFormState.getPasswordError() != null) {
                    passwordEditText.setError(getString(loginFormState.getPasswordError()));
                }
            }
        });
//
        loginViewModel.getLoginResult().observe(this, new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    updateUiWithUser(loginResult.getSuccess());
                }
                setResult(Activity.RESULT_OK);

                //Complete and destroy login activity once successful
                finish();
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // ignore
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                // ignore
            }

            @Override
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        };
        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    loginViewModel.login(usernameEditText.getText().toString(),
                            passwordEditText.getText().toString());
                }
                return false;
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                download.execute();
            }
        });
    }

    private void updateUiWithUser(LoggedInUserView model) {
        String welcome = getString(R.string.welcome) + model.getDisplayName();
        // TODO : initiate successful logged in experience
        Toast.makeText(getApplicationContext(), welcome, Toast.LENGTH_LONG).show();
    }

    private void showLoginFailed(@StringRes Integer errorString) {
        Toast.makeText(getApplicationContext(), errorString, Toast.LENGTH_SHORT).show();
    }

    private class GetJson extends AsyncTask<Void, Void, PessoaObj> {
        String dados = null, info = null;
        @Override
        protected void onPreExecute(){
            load = ProgressDialog.show(LoginActivity.this, "Por favor Aguarde ...", "Recuperando Informações do Servidor...");
        }

        @Override
        protected PessoaObj doInBackground(Void... params) {
            Utils util = new Utils();
            @SuppressLint("WrongThread") String url = "http://tcc2mauriciovictor-com.umbler.net/dados/"+usernameEditText.getText().toString();
            @SuppressLint("WrongThread") String url2 = "http://tcc2mauriciovictor-com.umbler.net/login/"+usernameEditText.getText().toString();
            dados = util.getDados(url);
            info = util.getInformacao(url2);
            return null;
        }

        @Override
        protected void onPostExecute(PessoaObj pessoa){
            Log.i("INFO", dados);
            Intent it = new Intent(LoginActivity.this, MainActivity.class);
            it.putExtra("info", info);
            it.putExtra("dados", dados);
            startActivity(it);
//            try {
//                String nome = null;
//                String comparar = "inexistente";
//                JSONObject jsonObj = new JSONObject(info);
//                nome = jsonObj.getString("nome");
//                Log.i("NOME", jsonObj.getString("nome"));
//                Toast.makeText(LoginActivity.this, nome, Toast.LENGTH_SHORT).show();
//                if(nome == comparar){
//                    Log.i("TEste", "caiu");
//                    Toast.makeText(LoginActivity.this, "NULO", Toast.LENGTH_SHORT).show();
//                    load.dismiss();
//                }else{
//                    Log.i("ELSE", "caiu");
//                    Intent it = new Intent(LoginActivity.this, MainActivity.class);
//                    it.putExtra("info", info);
//                    it.putExtra("dados", dados);
//                    startActivity(it);
//                }
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
            load.dismiss();
        }

    }
}
