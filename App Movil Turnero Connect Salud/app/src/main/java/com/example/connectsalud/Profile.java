package com.example.connectsalud;

<<<<<<< HEAD
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Profile extends AppCompatActivity {

    EditText dniTextView, nombreTextView, apellidoTextView, telefonoTextView, fechaNacimientoTextView, emailTextView;
=======
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;

public class Profile extends AppCompatActivity {

    private EditText editTextDni, editTextNombre, editTextApellido, editTextTelefono, editTextFechaNacimiento, editTextEmail;
    private AdminSQLiteOpenHelper databaseHelper;
    private SharedPreferences sharedPreferences;
    private long pacienteId;
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

<<<<<<< HEAD
        // Obtener datos de SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("user_data", MODE_PRIVATE);
        String dni = sharedPreferences.getString("dni", "");
        String nombre = sharedPreferences.getString("nombre", "");
        String apellido = sharedPreferences.getString("apellido", "");
        String telefono = sharedPreferences.getString("telefono", "");
        String fechaNacimiento = sharedPreferences.getString("fecha_nacimiento", "");
        String email = sharedPreferences.getString("email", "");

        // Convertir la fecha al formato dd/mm/aaaa
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        try {
            Date date = sdf.parse(fechaNacimiento);
            sdf.applyPattern("dd/MM/yyyy");
            fechaNacimiento = sdf.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Asignar datos a los EditTexts
        dniTextView = findViewById(R.id.dni);
        nombreTextView = findViewById(R.id.nombre);
        apellidoTextView = findViewById(R.id.apellido);
        telefonoTextView = findViewById(R.id.telefono);
        fechaNacimientoTextView = findViewById(R.id.fecha_nacimiento);
        emailTextView = findViewById(R.id.email);

        dniTextView.setText(dni);
        nombreTextView.setText(nombre);
        apellidoTextView.setText(apellido);
        telefonoTextView.setText(telefono);
        fechaNacimientoTextView.setText(fechaNacimiento);
        emailTextView.setText(email);
    }
}
=======
        editTextDni = findViewById(R.id.editTextDni);
        editTextNombre = findViewById(R.id.editTextNombre);
        editTextApellido = findViewById(R.id.editTextApellido);
        editTextTelefono = findViewById(R.id.editTextTelefono);
        editTextFechaNacimiento = findViewById(R.id.editTextFechaNacimiento);
        editTextEmail = findViewById(R.id.editTextEmail);
        databaseHelper = new AdminSQLiteOpenHelper(this);
        sharedPreferences = getSharedPreferences("UserPreferences", Context.MODE_PRIVATE);

        pacienteId = sharedPreferences.getLong("PACIENTE_ID", -1);
        if (pacienteId != -1) {
            loadProfileData(pacienteId);
        }
    }

    private void loadProfileData(long pacienteId) {
        Cursor cursor = databaseHelper.obtenerPacientePorId(pacienteId);
        if (cursor != null && cursor.moveToFirst()) {
            editTextDni.setText(cursor.getString(cursor.getColumnIndex("dni")));
            editTextNombre.setText(cursor.getString(cursor.getColumnIndex("nombre")));
            editTextApellido.setText(cursor.getString(cursor.getColumnIndex("apellido")));
            editTextTelefono.setText(cursor.getString(cursor.getColumnIndex("telefono")));
            editTextFechaNacimiento.setText(cursor.getString(cursor.getColumnIndex("fecha_nacimiento")));
            editTextEmail.setText(cursor.getString(cursor.getColumnIndex("email")));
            cursor.close();
        }
    }

    public void saveProfile(View view) {
        String dni = editTextDni.getText().toString().trim();
        String nombre = editTextNombre.getText().toString().trim();
        String apellido = editTextApellido.getText().toString().trim();
        String telefono = editTextTelefono.getText().toString().trim();
        String fechaNacimiento = editTextFechaNacimiento.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || fechaNacimiento.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean result = databaseHelper.actualizarUsuario(dni, nombre, apellido, telefono, fechaNacimiento, email);

        if (result) {
            Toast.makeText(this, "Perfil actualizado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error al actualizar el perfil. Inténtelo de nuevo", Toast.LENGTH_SHORT).show();
        }
    }
}
>>>>>>> 57c99725ee5aedee86c5302d43a5accc693b204d
