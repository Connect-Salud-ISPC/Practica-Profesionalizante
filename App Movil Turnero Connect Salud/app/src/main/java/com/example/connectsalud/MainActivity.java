package com.example.connectsalud;

import android.content.Intent;
<<<<<<< HEAD
=======
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
<<<<<<< HEAD
=======
import android.content.Context;
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
<<<<<<< HEAD
=======
    private AdminSQLiteOpenHelper databaseHelper;
    private SharedPreferences sharedPreferences;
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.input_email);
        passwordEditText = findViewById(R.id.input_pass1);
<<<<<<< HEAD
=======
        databaseHelper = new AdminSQLiteOpenHelper(this);
        sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d
    }

    public void launchHome(View view) {
        String email = emailEditText.getText().toString().trim();
        String password = passwordEditText.getText().toString().trim();

        if (isValidEmail(email) && isValidPassword(password)) {
<<<<<<< HEAD
            // Obtener el ID del paciente desde la base de datos o cualquier otra fuente
            long pacienteId = obtenerPacienteIdDesdeBaseDeDatos(email);

            // Credenciales válidas, iniciar la actividad Home con el ID del paciente como extra
            Intent intent = new Intent(this, Home.class);
            intent.putExtra("PACIENTE_ID", pacienteId);
            startActivity(intent);
            finish(); // Para evitar que el usuario vuelva atrás presionando el botón de retroceso
=======
            // Obtener el ID del paciente desde la base de datos
            long pacienteId = obtenerPacienteIdDesdeBaseDeDatos(email, password);

            if (pacienteId != -1) {
                // Guardar el ID del paciente en SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putLong("PACIENTE_ID", pacienteId);
                editor.apply();

                // Credenciales válidas, iniciar la actividad Home con el ID del paciente como extra
                Intent intent = new Intent(this, Home.class);
                intent.putExtra("PACIENTE_ID", pacienteId);
                startActivity(intent);
                finish(); // Para evitar que el usuario vuelva atrás presionando el botón de retroceso
            } else {
                // Credenciales inválidas, mostrar un mensaje de error
                Toast.makeText(this, "Credenciales inválidas. Inténtalo de nuevo.", Toast.LENGTH_SHORT).show();
            }
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d
        } else {
            // Credenciales inválidas, mostrar un mensaje de error
            Toast.makeText(this, "Credenciales inválidas. Inténtalo de nuevo.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private boolean isValidPassword(String password) {
        // Implementa tu lógica de validación de contraseña aquí
        // Por ejemplo, puedes verificar si la contraseña tiene una longitud mínima
        return password.length() >= 8;
    }

<<<<<<< HEAD
    private long obtenerPacienteIdDesdeBaseDeDatos(String email) {
        // Implementa la lógica para obtener el ID del paciente a partir del correo electrónico
        // Consulta la base de datos u otras fuentes según tus necesidades
        // Este método debe devolver el ID del paciente correspondiente al correo electrónico proporcionado
        return 1; // Ejemplo de ID del paciente (debes implementar la lógica real para obtenerlo)
=======
    private long obtenerPacienteIdDesdeBaseDeDatos(String email, String password) {
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        String[] projection = { "dni" };
        String selection = "email = ? AND pass = ?";
        String[] selectionArgs = { email, password };

        Cursor cursor = db.query(
                "usuarios",   // Nombre de la tabla
                projection,   // Columnas que quieres recuperar
                selection,    // Clausula WHERE
                selectionArgs,// Valores de la clausula WHERE
                null,         // No agrupar las filas
                null,         // No filtrar por grupos de filas
                null          // No ordenar las filas
        );

        long pacienteId = -1; // Valor predeterminado si no se encuentra el paciente

        if (cursor.moveToFirst()) {
            pacienteId = cursor.getLong(cursor.getColumnIndexOrThrow("dni"));
        }

        cursor.close();
        db.close();

        return pacienteId;
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d
    }

    public void launchRegister(View view) {
        Intent intent = new Intent(this, RegistroPaciente.class);
        startActivity(intent);
    }
<<<<<<< HEAD
}

=======
    public void launchWebsite(View view) {
        String url = "https://connectsalud.netlify.app/"; // Cambia esto a tu URL real
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

}
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d
