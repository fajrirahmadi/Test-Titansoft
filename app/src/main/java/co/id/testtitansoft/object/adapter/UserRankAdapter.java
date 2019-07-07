package co.id.testtitansoft.object.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import butterknife.BindView;
import butterknife.ButterKnife;
import co.id.testtitansoft.R;
import co.id.testtitansoft.object.UserRank;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

public class UserRankAdapter extends AbstractItem<UserRankAdapter, UserRankAdapter.ViewHolder> {


    private UserRank user;

    public UserRankAdapter(UserRank user) {
        this.user = user;
    }

    @Override
    public int getType() {
        return R.id.user_rank_id;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.adapter_user_rank;
    }

    @NonNull
    @Override
    public ViewHolder getViewHolder(View v) {
        return new ViewHolder(v);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.rankTextView)
        AppCompatTextView rankTextView;
        @BindView(R.id.usernameTextView)
        AppCompatTextView usernameTextView;
        Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }
    }

    @Override
    public void bindView(@NonNull ViewHolder holder,
                         @NonNull List<Object> payloads) {
        super.bindView(holder, payloads);
        holder.rankTextView.setText(String.valueOf(user.getRank()));
        holder.usernameTextView.setText(user.getUsername());
    }

    @Override
    public void unbindView(@NonNull ViewHolder holder) {
        super.unbindView(holder);
        holder.rankTextView.setText(null);
        holder.usernameTextView.setText(null);
    }
}
