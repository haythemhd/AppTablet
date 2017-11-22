package haythem.hd.appfortablet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragOne.OnFragmentInteractionListener{


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onFragmentInteraction(String ch) {

        FragTwo secondFrag = (FragTwo) getSupportFragmentManager().findFragmentById(R.id.details_frag_two);
        if (secondFrag == null) {
            // DisplayFragment (Fragment B) is not in the layout (handset layout),
            // so start DisplayActivity (Activity B)
            // and pass it the info about the selected item
            Intent mIntent = new Intent(MainActivity.this,SecondActivity.class) ;
            mIntent.putExtra("text", ch);
            startActivity(mIntent);
        } else {
            // DisplayFragment (Fragment B) is in the layout (tablet layout),
            // so tell the fragment to update
            FragTwo fragment=new FragTwo();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            // Replace whatever is in the fragment_container view with this fragment,
            // and add the transaction to the back stack so the user can navigate back
            transaction.replace(R.id.details_frag_two, fragment);
            transaction.addToBackStack(null);
            // Commit the transaction
            transaction.commit();
            fragment.updateContent(ch);
        }

    }
}
