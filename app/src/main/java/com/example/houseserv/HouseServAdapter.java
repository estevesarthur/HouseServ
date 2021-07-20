package com.example.houseserv;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HouseServAdapter extends RecyclerView.Adapter<HouseServAdapter.ViewHolder> {
    private List<HouseServMenu> houseServMenuListView;
    private Context context;

    public HouseServAdapter(Context context, List<HouseServMenu> houseServMenuListView) {
        this.context = context;
        this.houseServMenuListView = houseServMenuListView;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.houseserv_row_list, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder (@NonNull ViewHolder viewHolder, int position) {
        HouseServMenu data = houseServMenuListView.get(position);
        viewHolder.imgLogo.setImageResource(data.imgLogo);
        viewHolder.imgQuemSomos.setImageResource(data.imgQuemSomos);
        viewHolder.quemSomos.setText(data.quemSomos);
        viewHolder.imgNossoPortfolio.setImageResource(data.imgNossoPortfolio);
        viewHolder.nossoPortfolio.setText(data.nossoportfolio);
        viewHolder.imgContato.setImageResource(data.imgContato);
        viewHolder.contato.setText(data.contato);


        viewHolder.itemView.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setIcon(houseServMenuListView.get(position).imgLogo)
                    .setMessage("É um prazer ter você navegando aqui!" + " \n " + "Qualquer dúvida entre em contato." + " \n " + "Estamos aqui para achar uma solução para o seu negócio.")
                    .setCancelable(false)
                    .setPositiveButton("Close", null);
            builder.create().show();
            builder.setIcon(houseServMenuListView.get(position).imgQuemSomos)
                    .setTitle(houseServMenuListView.get(position).quemSomos);
            builder.setIcon(houseServMenuListView.get(position).imgNossoPortfolio)
                    .setTitle(houseServMenuListView.get(position).nossoportfolio);
            builder.setIcon(houseServMenuListView.get(position).imgContato)
                    .setTitle(houseServMenuListView.get(position).contato);

        });
    }

    @Override
    public int getItemCount(){ return houseServMenuListView.size(); }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView quemSomos, nossoPortfolio, contato;
        ImageView imgLogo, imgQuemSomos, imgNossoPortfolio, imgContato;
        LinearLayout parent;
        private CardView recycler_view;

        public ViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            imgLogo = itemView.findViewById(R.id.imgLogo);
            imgQuemSomos = itemView.findViewById(R.id.imgQuemSomos);
            quemSomos = itemView.findViewById(R.id.quemSomos);
            imgNossoPortfolio = itemView.findViewById(R.id.imgNossoPortfolio);
            nossoPortfolio = itemView.findViewById(R.id.nossoPortfolio);
            imgContato = itemView.findViewById(R.id.imgContato);
            contato = itemView.findViewById(R.id.contato);
            recycler_view = itemView.findViewById(R.id.recycler_view);
        }
    }
}
