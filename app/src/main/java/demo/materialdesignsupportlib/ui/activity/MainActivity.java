package demo.materialdesignsupportlib.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import demo.materialdesignsupportlib.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setOnItemClickListener(this);

        List<String> items = new ArrayList<String>();
        items.add(getResources().getString(R.string.title_activity_navview));
        items.add(getResources().getString(R.string.title_activity_floatlab));
        items.add(getResources().getString(R.string.title_activity_fab));
        items.add(getResources().getString(R.string.title_activity_snackbar));
        items.add(getResources().getString(R.string.title_activity_tabs));
        items.add(getResources().getString(R.string.title_activity_cl_fab));
        items.add(getResources().getString(R.string.title_activity_cl_toolbar_tab));
        items.add(getResources().getString(R.string.title_activity_cl_coll_toolbar_fab));
        items.add(getResources().getString(R.string.title_activity_cl_coll_toolbarpar_fab));


        ListAdapter list = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0: {
                startActivity(NavViewActivity.class);
                break;
            }
            case 1: {
                startActivity(FloatingLabelActivity.class);
                break;
            }
            case 2: {
                startActivity(FABActivity.class);
                break;
            }
            case 3: {
                startActivity(SnackBarActivity.class);
                break;
            }
            case 4: {
                startActivity(TabsActivity.class);
                break;
            }
            case 5: {
                startActivity(CoordLayFABActivity.class);
                break;
            }
            case 6: {
                startActivity(CoordLayToolbarTabActivity.class);
                break;
            }
            case 7: {
                startActivity(CoordLayCollToolbarFABActivity.class);
                break;
            }
            case 8: {
                startActivity(CoordLayCollToolbarParFABActivity.class);
                break;
            }
        }
    }

    private void startActivity(Class clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
}
