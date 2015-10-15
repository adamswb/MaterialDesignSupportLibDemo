package demo.materialdesignsupportlib.ui.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;

import demo.materialdesignsupportlib.R;

public class ScrollFlagDialogFragment extends DialogFragment {

    private int scrollFlags;

    public static ScrollFlagDialogFragment newInstance(int scrollFlags) {
        ScrollFlagDialogFragment fragment = new ScrollFlagDialogFragment();

        fragment.scrollFlags = scrollFlags;

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_scrollflags, null);

        final CheckBox cbScroll = (CheckBox) dialogView.findViewById(R.id.cbScroll);
        final CheckBox cbExitUntilCollapsed = (CheckBox) dialogView.findViewById(R.id.cbExitUntilCollapsed);
        final CheckBox cbEnterAlways = (CheckBox) dialogView.findViewById(R.id.cbEnterAlways);
        final CheckBox cbEnterAlwaysCollapsed = (CheckBox) dialogView.findViewById(R.id.cbEnterAlwaysCollapsed);

        cbScroll.setChecked((scrollFlags & AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL) == AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL);
        cbExitUntilCollapsed.setChecked((scrollFlags & AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED) == AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED);
        cbEnterAlways.setChecked((scrollFlags & AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS) == AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS);
        cbEnterAlwaysCollapsed.setChecked((scrollFlags & AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED) == AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED);

        builder.setTitle(R.string.scrollflags_title)
                .setView(dialogView)
                .setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        int scrollFlags = 0;

                        scrollFlags += cbScroll.isChecked() ? AppBarLayout.LayoutParams.SCROLL_FLAG_SCROLL : 0;
                        scrollFlags += cbExitUntilCollapsed.isChecked() ? AppBarLayout.LayoutParams.SCROLL_FLAG_EXIT_UNTIL_COLLAPSED : 0;
                        scrollFlags += cbEnterAlways.isChecked() ? AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS : 0;
                        scrollFlags += cbEnterAlwaysCollapsed.isChecked() ? AppBarLayout.LayoutParams.SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED : 0;

                        if (getActivity() instanceof Callback) {
                            ((Callback)getActivity()).onScrollFlagOKClick(scrollFlags);
                        }
                    }
                });

        // Create the AlertDialog object and return it
        return builder.create();
    }

    public interface Callback {
        void onScrollFlagOKClick(int scrollFlags);
    }
}
