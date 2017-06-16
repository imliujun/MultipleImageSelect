package com.darsh.multipleimageselect.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.darsh.multipleimageselect.R;
import com.darsh.multipleimageselect.helpers.Constants;
import com.darsh.multipleimageselect.models.Album;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.util.ArrayList;

/**
 * 项目名称：MultipleImageSelect
 * 类描述：
 * 创建人：Darshan
 * 创建时间：4/14/2015
 * 修改人：LiuJun
 * 修改时间：6/16/2017 10:39
 * 修改备注：Replace Glide with Fresco
 */
public class CustomAlbumSelectAdapter extends CustomGenericAdapter<Album> {
    public CustomAlbumSelectAdapter(Context context, ArrayList<Album> albums) {
        super(context, albums);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_view_item_album_select, null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = (SimpleDraweeView) convertView
                    .findViewById(R.id.image_view_album_image);
            viewHolder.textView = (TextView) convertView.findViewById(R.id.text_view_album_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.getLayoutParams().width = size;
        viewHolder.imageView.getLayoutParams().height = size;

        viewHolder.textView.setText(arrayList.get(position).name);
        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.fromFile(new File(arrayList.get(position).cover)))
                .setLocalThumbnailPreviewsEnabled(true)
                .setResizeOptions(new ResizeOptions(size, size)).build();
        DraweeController controller = Fresco.newDraweeControllerBuilder()
                                            .setAutoPlayAnimations(Constants.isSupportGif)
                                            .setImageRequest(imageRequest)
                                            .setOldController(viewHolder.imageView.getController())
                                            .build();
        viewHolder.imageView.setController(controller);
        return convertView;
    }


    private static class ViewHolder {
        public SimpleDraweeView imageView;
        public TextView textView;
    }
}
