package com.solicita.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.solicita.R;
import com.solicita.helper.SharedPrefManager;
import com.solicita.model.Solicitacoes;
import com.solicita.network.ApiClient;
import com.solicita.network.ApiInterface;

import java.util.List;

public class AdapterDocumentos extends RecyclerView.Adapter<AdapterDocumentos.MyViewHolder> {

    private List<Solicitacoes> listaSolicitacoes;
    private Context context;
    private SharedPrefManager sharedPrefManager;
    private ApiInterface apiInterface;


    public AdapterDocumentos(List<Solicitacoes> lista, Context context) {

        sharedPrefManager = new SharedPrefManager(context);
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        this.listaSolicitacoes = lista;
        this.context = context;

    }

    public void removerItem(int position){
        listaSolicitacoes.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, listaSolicitacoes.size());

    }


    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemLista = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista_documentos, parent, false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Solicitacoes solicitacoes = listaSolicitacoes.get(position);

        holder.textCursoAdap.setText(solicitacoes.getAbreviatura());
        holder.textStatusAdap.setText(solicitacoes.getStatus());
        holder.textSolicitadosAdap.setText(solicitacoes.getDocumentosSolicitados());

    }

    @Override
    public int getItemCount() {
        return listaSolicitacoes.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textCursoAdap, textStatusAdap, textSolicitadosAdap;

        public MyViewHolder(View itemView){
            super(itemView);

            textCursoAdap=itemView.findViewById(R.id.textCursoAdap);
            textStatusAdap=itemView.findViewById(R.id.textStatusAdap);
            textSolicitadosAdap=itemView.findViewById(R.id.textSolicitadosAdap);
        }
    }
}
