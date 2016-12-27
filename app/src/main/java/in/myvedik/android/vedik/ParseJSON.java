package in.myvedik.android.vedik;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import static in.myvedik.android.vedik.ParsingConstants.*;

/**
 * Created by admin on 22-12-2016.
 */

public class ParseJSON {


    public ArrayList<HashMap<String, String>> getPostData(JSONArray jsonArray) {
        ArrayList<HashMap<String, String>> list = new ArrayList<>();


        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                HashMap<String, String> hashMap=new HashMap<>();

                JSONObject post = jsonArray.getJSONObject(i);

                if (!post.isNull(TAG_VIDEO_ID)) {
                    JSONObject videoId = post.getJSONObject(TAG_VIDEO_ID);

                    hashMap.put(TAG_ID, videoId.getString(TAG_ID));
                    hashMap.put(TAG_NAME, videoId.getString(TAG_NAME));
                    hashMap.put(TAG_VID_URL, videoId.getString(TAG_VID_URL));
                    hashMap.put(TAG_POSTER_URL, videoId.getString(TAG_POSTER_URL));


                    JSONArray description = videoId.getJSONArray(TAG_DESCRIPTION);
                    for (int j = 0; j < description.length(); j++) {
                        hashMap.put("TAG_DESCRIPTION" + j, description.get(j).toString());
                    }

                    hashMap.put(TAG_TYPE,""+post.getInt(TAG_TYPE));
                    hashMap.put(TAG_SCORE, post.getString(TAG_SCORE));
                    hashMap.put(TAG_CREATED_ON, post.getString(TAG_CREATED_ON));

                    JSONArray viewCount = post.getJSONArray(TAG_VIEW_COUNT);
                    hashMap.put(TAG_VIEWS, "" + viewCount.length());

                    JSONArray postVediks = post.getJSONArray("vedik");
                    for (int j = 0; j < postVediks.length(); j++) {
                        JSONObject c = postVediks.getJSONObject(j);
                        JSONObject vedik = c.getJSONObject(TAG_VEDIK);
                        hashMap.put(TAG_VEDIK_NAME+j, vedik.getString(TAG_NAME));
                    }

                    JSONArray awards = post.getJSONArray(TAG_AWARDS);
                    for (int j = 0; j < awards.length(); j++) {
                        JSONObject c = awards.getJSONObject(i);
                        JSONObject event = c.getJSONObject(TAG_EVENT);
                        hashMap.put(TAG_EVENT_NAME+j, event.getString(TAG_NAME));

                        JSONObject club = event.getJSONObject(TAG_CLUB);
                        hashMap.put(TAG_CLUB_NAME+j, club.getString(TAG_NAME));

                        hashMap.put(TAG_POSITION+j, c.getString(TAG_POSITION));
                    }

                    hashMap.put(TAG_RATING, post.getString(TAG_RATING));

                    JSONArray comments = post.getJSONArray(TAG_COMMENTS);
                    for (int j = 0; j < comments.length(); j++) {
                        JSONObject c = comments.getJSONObject(j);
                        if(!c.isNull(TAG_COMMENT)){
                            JSONObject comment = c.getJSONObject(TAG_COMMENT);
                            hashMap.put(TAG_COMMENT_PUTTER+j, comment.getString(TAG_COMMENT_PUTTER));
                            hashMap.put(TAG_COMMENT_DATA+j, comment.getString(TAG_COMMENT_DATA));
                        }

                    }

                    JSONArray likes = post.getJSONArray(TAG_LIKES);
                    hashMap.put(TAG_LIKES, likes.length() + "");

                    JSONObject uploader = post.getJSONObject(TAG_UPLOADER);
                    JSONObject uploaderInfo = uploader.getJSONObject(TAG_USER);
                    hashMap.put(TAG_UPLOADER_NAME, uploaderInfo.getString(TAG_NAME));
                    hashMap.put(TAG_UPLOADER_INSTI, uploaderInfo.getString(TAG_UPLOADER_INSTI));
                    hashMap.put(TAG_UPLOADER_PIC, uploaderInfo.getString(TAG_UPLOADER_PIC));

                    list.add(hashMap);

                }

                else {
                    JSONObject imageId = post.getJSONObject(TAG_IMAGE_ID);

                    hashMap.put(TAG_ID, imageId.getString(TAG_ID));
                    hashMap.put(TAG_NAME, imageId.getString(TAG_NAME));

                    JSONArray description = imageId.getJSONArray(TAG_DESCRIPTION);
                    for (int j = 0; j < description.length(); j++) {
                        hashMap.put(TAG_DESCRIPTION + j, description.get(j).toString());
                    }

                    JSONArray picUrls = imageId.getJSONArray(TAG_PIC_URL);
                    final int len = picUrls.length();
                    for (int j = 0; j < len; j++) {
                        hashMap.put(TAG_PIC_URL + j, picUrls.get(j).toString());
                    }

                    hashMap.put(TAG_TYPE, post.getString(TAG_TYPE));
                    hashMap.put(TAG_SCORE, post.getString(TAG_SCORE));
                    hashMap.put(TAG_CREATED_ON, post.getString(TAG_CREATED_ON));

                    JSONArray viewCount = post.getJSONArray(TAG_VIEW_COUNT);
                    hashMap.put(TAG_VIEWS, "" + viewCount.length());

                    JSONArray postVediks = post.getJSONArray("vedik");
                    for (int j = 0; j < postVediks.length(); j++) {
                        JSONObject c = postVediks.getJSONObject(j);
                        JSONObject vedik = c.getJSONObject(TAG_VEDIK);
                        hashMap.put(TAG_VEDIK_NAME+j, vedik.getString(TAG_NAME));
                    }

                    JSONArray awards = post.getJSONArray(TAG_AWARDS);
                    for (int j = 0; j < awards.length(); j++) {
                        JSONObject c = awards.getJSONObject(j);
                        JSONObject event = c.getJSONObject(TAG_EVENT);
                        hashMap.put(TAG_EVENT_NAME+j, event.getString(TAG_NAME));

                        JSONObject club = event.getJSONObject(TAG_CLUB);
                        hashMap.put(TAG_CLUB_NAME+j, club.getString(TAG_NAME));

                        hashMap.put(TAG_POSITION+j, c.getString(TAG_POSITION));
                    }

                    hashMap.put(TAG_RATING, post.getString(TAG_RATING));

                    JSONArray comments = post.getJSONArray(TAG_COMMENTS);
                    for (int j = 0; j < comments.length(); j++) {
                        JSONObject c = comments.getJSONObject(j);
                        if(!c.isNull(TAG_COMMENT)){
                            JSONObject comment = c.getJSONObject(TAG_COMMENT);
                            hashMap.put(TAG_COMMENT_PUTTER+j, comment.getString(TAG_COMMENT_PUTTER));
                            hashMap.put(TAG_COMMENT_DATA+j, comment.getString(TAG_COMMENT_DATA));
                        }

                    }

                    JSONArray likes = post.getJSONArray(TAG_LIKES);
                    hashMap.put(TAG_LIKES, likes.length() + "");

                    JSONObject uploader = post.getJSONObject(TAG_UPLOADER);
                    JSONObject uploaderInfo = uploader.getJSONObject(TAG_USER);
                    hashMap.put(TAG_UPLOADER_NAME, uploaderInfo.getString(TAG_NAME));
                    hashMap.put(TAG_UPLOADER_INSTI, uploaderInfo.getString(TAG_UPLOADER_INSTI));
                    hashMap.put(TAG_UPLOADER_PIC, uploaderInfo.getString(TAG_UPLOADER_PIC));

                    list.add(hashMap);
                }
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
        return list;
    }
}

