package com.example.lucas.piquinto.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lucas.piquinto.R;

public class CadastroActivity extends AppCompatActivity {

    private EditText nome, sobrenome, idade, usuario, senha;
    private Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = findViewById(R.id.editNome_id);
        sobrenome = findViewById(R.id.editSobrenome_id);
        idade = findViewById(R.id.editIdade_id);
        usuario = findViewById(R.id.editUsuario_id);
        senha = findViewById(R.id.editSenha_id);

        btnCadastrar = findViewById(R.id.btnCadastrar_id);
    }

    public void onReg(View view){

        String strNome = nome.getText().toString();
        String strSobrenome = sobrenome.getText().toString();
        String strIdade = idade.getText().toString();
        String strUsuario = usuario.getText().toString();
        String strSenha = senha.getText().toString();
        String type = "register";
        BackGroundWork worker = new BackGroundWork(this);
        worker.execute(type, strNome, strSobrenome, strIdade, strUsuario, strSenha);

    }

}
