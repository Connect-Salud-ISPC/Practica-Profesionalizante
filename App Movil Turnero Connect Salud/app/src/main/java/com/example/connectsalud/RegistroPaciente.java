package com.example.connectsalud;

<<<<<<< HEAD
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistroPaciente extends AppCompatActivity {

    EditText agregardnipaciente, agregarnombrepaciente, agregarapellidopaciente,
            agregartelefonopaciente, agregarnacimientopaciente, agregarmailpaciente,
            agregarpasspaciente, agregarpassagainpaciente;
    AdminSQLiteOpenHelper admin;
=======
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroPaciente extends AppCompatActivity {

    private EditText editTextDni, editTextNombre, editTextApellido, editTextTelefono, editTextFechaNacimiento, editTextEmail, editTextPassword, editTextPasswordAgain;
    private AdminSQLiteOpenHelper databaseHelper;
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registropaciente);

<<<<<<< HEAD
        agregardnipaciente = findViewById(R.id.agregardnipaciente);
        agregarnombrepaciente = findViewById(R.id.agregarnombrepaciente);
        agregarapellidopaciente = findViewById(R.id.agregarapellidopaciente);
        agregartelefonopaciente = findViewById(R.id.agregartelefonopaciente);
        agregarnacimientopaciente = findViewById(R.id.agregarnacimientopaciente);
        agregarmailpaciente = findViewById(R.id.agregarmailpaciente);
        agregarpasspaciente = findViewById(R.id.agregarpasspaciente);
        agregarpassagainpaciente = findViewById(R.id.agregarpassagainpaciente);

        // Setear el hint en blanco cuando se hace clic en los campos
        agregardnipaciente.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    agregardnipaciente.setHint("");
                } else {
                    agregardnipaciente.setHint("DNI");
                }
            }
        });

        // Repite el bloque anterior para los demás campos según sea necesario.

        admin = new AdminSQLiteOpenHelper(this);
    }

    public void agregarPaciente(View view) {
        SQLiteDatabase db = admin.getWritableDatabase();
        ContentValues registro = new ContentValues();
        registro.put("dni", agregardnipaciente.getText().toString());
        registro.put("nombre", agregarnombrepaciente.getText().toString());
        registro.put("apellido", agregarapellidopaciente.getText().toString());
        registro.put("telefono", agregartelefonopaciente.getText().toString());
        registro.put("fecha_nacimiento", agregarnacimientopaciente.getText().toString());
        registro.put("email", agregarmailpaciente.getText().toString());
        registro.put("pass", agregarpasspaciente.getText().toString());
        registro.put("passagain", agregarpassagainpaciente.getText().toString());

        // Insertar datos en la base de datos
        db.insert("usuarios", null, registro);

        // Guardar datos en SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("dni", agregardnipaciente.getText().toString());
        editor.putString("nombre", agregarnombrepaciente.getText().toString());
        editor.putString("apellido", agregarapellidopaciente.getText().toString());
        editor.putString("telefono", agregartelefonopaciente.getText().toString());
        editor.putString("fecha_nacimiento", agregarnacimientopaciente.getText().toString());
        editor.putString("email", agregarmailpaciente.getText().toString());
        //
        editor.apply();

        // Limpiar campos de entrada y mostrar mensaje de éxito
        limpiarCampos();
        db.close();
        Toast.makeText(this, "Se almacenó el usuario", Toast.LENGTH_SHORT).show();
    }

    private void limpiarCampos() {
        // Limpiar campos de entrada
        agregardnipaciente.setText("");
        agregarnombrepaciente.setText("");
        agregarapellidopaciente.setText("");
        agregartelefonopaciente.setText("");
        agregarnacimientopaciente.setText("");
        agregarmailpaciente.setText("");
        agregarpasspaciente.setText("");
        agregarpassagainpaciente.setText("");
    }
}
=======
        editTextDni = findViewById(R.id.editTextDni);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextFechaNacimiento = findViewById(R.id.editTextFechaNacimiento);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordAgain = findViewById(R.id.editTextPasswordAgain);
        databaseHelper = new AdminSQLiteOpenHelper(this);
    }

    public void registerUser(View view) {
        String dni = editTextDni.getText().toString().trim();
        String nombre = editTextNombre.getText().toString().trim();
        String apellido = editTextApellido.getText().toString().trim();
        String telefono = editTextTelefono.getText().toString().trim();
        String fechaNacimiento = editTextFechaNacimiento.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String passwordAgain = editTextPasswordAgain.getText().toString().trim();

        if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || fechaNacimiento.isEmpty() || email.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Por favor, introduzca un correo electrónico válido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (password.length() < 8) {
            Toast.makeText(this, "La contraseña debe tener al menos 8 caracteres", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(passwordAgain)) {
            Toast.makeText(this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
            return;
        }

        long result = databaseHelper.insertarUsuario(dni, nombre, apellido, telefono, fechaNacimiento, email, password, passwordAgain);

        if (result != -1) {
            Toast.makeText(this, "Registro exitoso", Toast.LENGTH_SHORT).show();
            finish(); // Cierra la actividad y regresa a la anterior
        } else {
            Toast.makeText(this, "Error en el registro. Inténtelo de nuevo", Toast.LENGTH_SHORT).show();
        }
    }
}
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d
