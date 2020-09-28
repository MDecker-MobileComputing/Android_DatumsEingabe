package de.mide.datumseingabe;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Toast;


/**
 * App zur Demonstration Event-Handling für UI-Element "DatePicker",
 * mit dem Datums-Werte in einem Kalender oder mit Rollen ausgewählt
 * werden können.
 * <br><br>
 *
 * This project is licensed under the terms of the BSD 3-Clause License.
 */
public class MainActivity extends Activity
                          implements OnDateChangedListener {

    /**
     * Lifecycle-Methode zur Initialisierung des Activity-Objekts.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
		
        super.onCreate(savedInstanceState);

        setContentView( R.layout.datums_activity );

        DatePicker datePicker = findViewById(R.id.d1);

        datePicker.init(2020, 8, 28, this); // 8=September
    }


    /**
     * Event-Handler-Methode für DatePicker-Element;
     * einzige Methode aus Interface {@link OnDateChangedListener}.
     *
     * @param view  UI-Element, welches das Event ausgelöst hat.
     * 
     * @param year  Jahreszahl des neuen Datums, z.B. 2018.
     *
     * @param monthOfYear  Monat des neuen Datums; 0-basiert, also z.B. "10" für "November".
     *
     * @param dayOfMonth  Nummer Tag (1-basiert), z.B. 31. für den letzten Tag im Januar.
     */
    @Override
    public void onDateChanged(DatePicker view,
                              int year, int monthOfYear, int dayOfMonth) {

        String toastText = null;

        if (year > 2020) {

            toastText = "Erst im nächsten Jahr";

        } else {

            toastText = "Neues Datum: "    +
                           dayOfMonth      + "." +
                           (monthOfYear+1) + "." +
                           year;
        }

        Toast.makeText(this, toastText, Toast.LENGTH_LONG).show();
    }

}
