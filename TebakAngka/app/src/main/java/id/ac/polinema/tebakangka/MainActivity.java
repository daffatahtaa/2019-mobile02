package id.ac.polinema.tebakangka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class MainActivity extends AppCompatActivity {

	//  TODO: deklarasikan variabel di sini
	private int angkaRandom;
	private EditText editText;
	private Button button;
	private Button reset;
	private TextView input;
	private int ans;
	Random random = new Random();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// TODO: bind layout di sini
		initRandomNumber();
		button = findViewById(R.id.guess_button);
		reset = findViewById(R.id.reset_button);
		reset.setEnabled(false);
	}

	// TODO: generate angka random di sini
	private void initRandomNumber() {
		angkaRandom = random.nextInt(100)+1;
	}

	public void handleGuess(View view) {
		// TODO: Tambahkan logika untuk melakukan pengecekan angka
		editText = (EditText) findViewById(R.id.number_input);

		ans =  Integer.parseInt(editText.getText().toString());

		if (angkaRandom == ans){
			Toast.makeText(this, "Selamat Tebakan anda Benar!", Toast.LENGTH_SHORT).show();
			reset.setEnabled(true);
			button.setEnabled(false);
		}else if (angkaRandom > ans){
			Toast.makeText(this, "Angka Tebakan Terlalu Kecil", Toast.LENGTH_SHORT).show();
		}else if (angkaRandom < ans){
			Toast.makeText(this, "Angka Tebakan Terlalu Besar", Toast.LENGTH_SHORT).show();
		}
		Log.i("angka random : " , Integer.toString(angkaRandom));
		Log.i("jawab : ", Integer.toString(ans));
	}

	public void handleReset (View view) {
		//initRandomNumber();
		newGame();
	}

	private void newGame(){
		angkaRandom = random.nextInt(100)+1;
		button.setEnabled(true);
		reset.setEnabled(false);
	}

}
