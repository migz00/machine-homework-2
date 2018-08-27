package com.migue.machine_homework_2;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener{

    Planets[] planet = {new Planets("Earth", R.drawable.earth, "Part of The Solar System"),
                        new Planets("Saturn", R.drawable.saturn, "Part of The Solar System"),
                        new Planets("Jupiter", R.drawable.jupiter, "Part of The Solar System"),
                        new Planets("Mars", R.drawable.mars, "Part of The Solar System"),
                        new Planets("Mercury", R.drawable.mercury, "Part of The Solar System"),
                        new Planets("Neptune", R.drawable.neptune, "Part of The Solar System"),
                        new Planets("Uranus", R.drawable.uranus, "Part of The Solar System"),
                        new Planets("Venus", R.drawable.venus, "Part of The Solar System"),
                        new Planets("Pluto", R.drawable.pluto, "Not Part of The Solar System")};

    private ListView listView = null;
    PlanetAdapter adapter = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.lv_plan);
        adapter = new PlanetAdapter(this, R.layout.activity_planet_adapter, planet);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
        listView.setOnItemLongClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv_iname = view.findViewById(R.id.tv_pname);
        Planets x = adapter.getItem(position);
        Toast.makeText(this, tv_iname.getText().toString()+" is "+ x.getStat(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv_iname = view.findViewById(R.id.tv_pname);
        Planets x = adapter.getItem(position);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Planet Information");
        builder.setMessage("Planet: "+tv_iname.getText().toString()+"\n"
                            +"Status: "+x.getStat());
        builder.setPositiveButton("OK", dialogListener);
        builder.show();
        return true;
    }
    private DialogInterface.OnClickListener dialogListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            switch(which){
                case DialogInterface.BUTTON_POSITIVE:
                    break;
            }
        }
    };
}

class Planets{
    private String name = null;
    private int image = -1;
    private String desc = null;

    public Planets(String name, int image, String desc)
    {
        this.name = name;
        this.image = image;
        this.desc = desc;
    }
    public String getName()
    {
        return name;
    }
    public int getSrc()
    {
        return image;
    }
    public String getStat(){
        return desc;
    }
}
