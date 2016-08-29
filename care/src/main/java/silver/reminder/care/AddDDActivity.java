package silver.reminder.care;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import silver.reminder.R;

public class AddDDActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;
    private ImageButton ibnCamera;
    private Button btnMember;
    private Button btnMeal;
    private Button btnDrug;
    private Button btnCycle;
    private Button btnTime;
    private AlertDialog adMember;
    private AlertDialog adMeal;
    private AlertDialog adDrug;
    private AlertDialog adCycle;
    private AlertDialog adClock;
    private View vDrug;
    private ListView lvDrug;
    private ListView lvMember;
    private ArrayAdapter<String> aaDrug;
    private ArrayAdapter<String> aaMember;
    private List<String> arDrug = new ArrayList<String>();
    private List<String> arMember = new ArrayList<String>();

    private View vMember;
    private View vMeal;
    private View vCycle;
    private View vClock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care_main_adddd);
        findView();
        createController();


    }

    //連結物件
    private void findView() {
        ibnCamera = (ImageButton) findViewById(R.id.ibnCamera);
        btnMember = (Button) findViewById(R.id.btnMember);
        btnMeal = (Button) findViewById(R.id.btnMeal);
        btnDrug = (Button) findViewById(R.id.btnDrug);
        btnCycle = (Button) findViewById(R.id.btnCycle);
        btnTime = (Button) findViewById(R.id.btnTime);

        vDrug = getLayoutInflater().inflate(R.layout.care_code, null);
        lvDrug = (ListView) vDrug.findViewById(R.id.lvCode);
        arDrug.add("熱敷10分鐘");
        arDrug.add("降膽固醇藥1顆");
        arDrug.add("葡萄糖胺20c.c.");
        arDrug.add("維他命1顆");
        arDrug.add("喝水一杯");
        arDrug.add("葉黃素2顆");
        arDrug.add("眼藥水左右眼各一滴");
        arDrug.add("感冒藥一包");
        arDrug.add("貼布一片");
        aaDrug = new ArrayAdapter<String>(
            AddDDActivity.this,
            android.R.layout.simple_list_item_multiple_choice,
            arDrug
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                text1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                return view;
            }
        };
        lvDrug.setAdapter(aaDrug);
        lvDrug.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        vMember = getLayoutInflater().inflate(R.layout.care_code, null);
        lvMember = (ListView) vMember.findViewById(R.id.lvCode);
        arMember.add("爺爺");
        aaMember = new ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_single_choice,
            arMember
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                TextView text1 = (TextView) view.findViewById(android.R.id.text1);
                text1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 25);
                return view;
            }
        };
        lvMember.setAdapter(aaMember);
        lvMember.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        vMeal = getLayoutInflater().inflate(R.layout.care_popup_meal, null);

    }

    private void createController() {
        adMember = new AlertDialog.Builder(this, R.style.AppTheme_Care_DialogAlert)
            .setView(vMember)
            .setPositiveButton("確定", null)
            .create();

        adMeal = new AlertDialog.Builder(this, R.style.AppTheme_Care_DialogAlert)
            .setView(vMeal)
            .create();

        adDrug = new AlertDialog.Builder(this, R.style.AppTheme_Care_DialogAlert)
            .setView(vDrug)
            .setPositiveButton("確定", null)
            .create();

    }

    public void returnCare(View view) {
        startActivity(new Intent().setClass(this, CareActivity.class));
    }

    public void doCycle(View view) {
        Intent intent = new Intent().setClass(this, AddDDCycleActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doTime(View view) {
        Intent intent = new Intent().setClass(this, AddDDTimeActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doDrug(View view) {
        adDrug.show();
    }

    public void doMorning(View view) {
        Intent intent = new Intent().setClass(this, AddDDClockActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doNoon(View view) {
        Intent intent = new Intent().setClass(this, AddDDClockActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doAfternoon(View view) {
        Intent intent = new Intent().setClass(this, AddDDClockActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void doNight(View view) {
        Intent intent = new Intent().setClass(this, AddDDClockActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }


    public void doMeal(View view) {
        adMeal.show();
    }

    public void doMember(View view) {
        adMember.show();
    }
}
