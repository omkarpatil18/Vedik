package in.myvedik.android.vedik;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.HashMap;

import static in.myvedik.android.vedik.ParsingConstants.*;


/**
 * Created by admin on 20-12-2016.
 */


public class UserPostFragment extends Fragment {

    private HashMap<String,String> hashMap;

    private ImageView mUploaderAvatarImageView;
    private TextView mUploaderNameTextView;
    private TextView mUploaderWorkTextView;
    private TextView mUploadVedikTextView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            hashMap = (HashMap<String,String>) getArguments().getSerializable("POST_CONTENT");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(
                R.layout.fragment_user_post, container, false);

        mUploaderAvatarImageView= (ImageView) rootView.findViewById(R.id.uploader_avatar);
        mUploaderNameTextView=(TextView) rootView.findViewById(R.id.uploader_name);
        mUploaderWorkTextView=(TextView) rootView.findViewById(R.id.uploader_work_profile);
        mUploadVedikTextView=(TextView) rootView.findViewById(R.id.upload_vedik);

        if(Integer.parseInt(hashMap.get(TAG_TYPE))>130){

            Fragment postFragment = new VideoFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(R.id.post_fragment_container, postFragment).commit();

        }else{
            Fragment postFragment = new ImageFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            Bundle bundle = new Bundle();
            bundle.putInt("NUMBER_OF_IMAGES", Integer.parseInt(hashMap.get(TAG_TYPE)));
            bundle.putString("URL",hashMap.get(TAG_PIC_URL+0));
            postFragment.setArguments(bundle);
            transaction.add(R.id.post_fragment_container, postFragment).commit();
        }



        return rootView;
    }
}
