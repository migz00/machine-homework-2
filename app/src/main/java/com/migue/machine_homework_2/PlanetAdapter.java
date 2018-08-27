package com.migue.machine_homework_2;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PlanetAdapter extends ArrayAdapter<Planets> {

    private Planets[] planet = null;
    private Context context = null;
    private int LayoutRes = -1;
    public PlanetAdapter(@NonNull Context context, int resource, @NonNull Planets[] planet) {
        super(context, resource, planet);

        this.planet = planet;
        this.context = context;
        LayoutRes = resource;
    }

    @Nullable
    @Override
    public Planets getItem(int position) {
        return planet[position];
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planets plan = getItem(position);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View planetItemLayout = inflater.inflate(LayoutRes, parent, false);
        TextView planetName = planetItemLayout.findViewById(R.id.tv_pname);
        ImageView planetsrc = planetItemLayout.findViewById(R.id.iv_pimage);

        planetName.setText(plan.getName());
        planetsrc.setImageResource(plan.getSrc());

        return planetItemLayout;
    }
}
