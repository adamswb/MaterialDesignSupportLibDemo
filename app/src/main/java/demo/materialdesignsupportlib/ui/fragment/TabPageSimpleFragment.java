package demo.materialdesignsupportlib.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TabPageSimpleFragment extends Fragment {

    private static final String TAB_POSITION = "tab_position";

    public static final TabPageSimpleFragment newInstance(int tabPosition) {
        TabPageSimpleFragment fragment = new TabPageSimpleFragment();

        Bundle bundle = new Bundle();
        bundle.putInt(TAB_POSITION, tabPosition);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView tvText = new TextView(getActivity());

        tvText.setText("Tab #" + getArguments().getInt(TAB_POSITION));

        return tvText;
    }

}
