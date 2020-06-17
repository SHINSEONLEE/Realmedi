package org.techtown.mediclock;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> implements Filterable {

    private ArrayList<Recent> mList;
    private ArrayList<Recent> filterList;
    private LayoutInflater mInflate;
    private Context mContext;
    SearchView searchView;


    public RecyclerviewAdapter(Context context, ArrayList<Recent> items) {
        this.filterList = items;
        this.mList = items;
        this.mInflate = LayoutInflater.from(context);
        this.mContext = context;
    }

    @Override
    public RecyclerviewAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new MyViewHolder(view);
    }

    private onItemListener mListener;
    public void setOnClickListener(onItemListener listener){
        mListener = listener;
    }

    public void dataSetChanged(ArrayList<Recent> exampleList){
        filterList = exampleList;
        notifyDataSetChanged();
    }

    @Override // 뷰 홀더가 필요한 위치에 할당 될 때, 어댑터는 onBindViewHolder() 함수를 호출
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.ITEM_NAME.setText(filterList.get(position).getITEM_NAME());
        holder.ENTP_NAME.setText(filterList.get(position).getENTP_NAME());

        if(mListener != null){
            final int pos = position;
            holder.itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    mListener.onItemClicked(position);
                }
            });
        }
    }

    public Filter getFilter(){
        return exampleFilter;
    }

    @Override // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() { //전체 아이템 갯수 리턴.
        return this.filterList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder { // 아이템 뷰를 저장하는 뷰홀더 클래스.
        private TextView ITEM_NAME, ENTP_NAME;

        public MyViewHolder(View itemView) {
            super(itemView);
            ITEM_NAME = itemView.findViewById(R.id.item_name);
            ENTP_NAME = itemView.findViewById(R.id.entp_name);
        }
    }

    public interface onItemListener{
        void onItemClicked(int position);
    }

    public Filter exampleFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String charString = constraint.toString();
            Log.e("CHAR String", charString);
            if (charString.isEmpty()) {
                filterList = mList;
            } else {
                ArrayList<Recent> filteringList = new ArrayList<>();
                // Log.e("CHAR String222", charString);
                for (Recent item : mList) {
                    if (item.getITEM_NAME().contains(charString.trim())) {//toLowerCase()., .toLowerCase()
                        filteringList.add(item);
                    }
                }
                Log.e("FilteringlistLength", String.valueOf(filteringList.size()));
                filterList = filteringList;
                Log.e("FilterListLength", String.valueOf(filterList.size()));
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filterList;
            return filterResults;
        }
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filterList = (ArrayList<Recent>) results.values;
            Log.e("final filterList", String.valueOf(filterList.size()));

            notifyDataSetChanged();
        }
    };
}