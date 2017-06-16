package com.darsh.multipleimageselect.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.darsh.multipleimageselect.R;
import com.darsh.multipleimageselect.helpers.Constants;
import com.darsh.multipleimageselect.models.Image;
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
 * 创建时间：4/18/2015
 * 修改人：LiuJun
 * 修改时间：6/16/2017 10:39
 * 修改备注：Replace Glide with Fresco
 */
public class CustomImageSelectAdapter extends CustomGenericAdapter<Image> {
    public CustomImageSelectAdapter(Context context, ArrayList<Image> images) {
        super(context, images);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_view_item_image_select, null);

            viewHolder = new ViewHolder();
            viewHolder.imageView = (SimpleDraweeView) convertView
                    .findViewById(R.id.image_view_image_select);
            viewHolder.view = convertView.findViewById(R.id.view_alpha);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.imageView.getLayoutParams().width = size;
        viewHolder.imageView.getLayoutParams().height = size;

        viewHolder.view.getLayoutParams().width = size;
        viewHolder.view.getLayoutParams().height = size;

        if (arrayList.get(position).isSelected) {
            viewHolder.view.setAlpha(0.5f);
            ((FrameLayout) convertView)
                    .setForeground(context.getResources().getDrawable(R.drawable.ic_done_white));
        } else {
            viewHolder.view.setAlpha(0.0f);
            ((FrameLayout) convertView).setForeground(null);
        }

        ImageRequest imageRequest = ImageRequestBuilder
                .newBuilderWithSource(Uri.fromFile(new File(arrayList.get(position).path)))
                .setResizeOptions(new ResizeOptions(size, size))
                .setLocalThumbnailPreviewsEnabled(true).build();
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
        public View view;
    }
}
