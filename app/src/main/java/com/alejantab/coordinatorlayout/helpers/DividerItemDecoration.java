package com.alejantab.coordinatorlayout.helpers;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alejantab.coordinatorlayout.R;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int[] ATTRS = new int[]{android.R.attr.listDivider};

    private Context context;
    private ListOrientation listOrientation;
    private Drawable dividerDrawable;

    public enum ListOrientation {
        HORIZONTAL, VERTICAL
    }

    public DividerItemDecoration(Context context, ListOrientation listOrientation) {
        this.context = context;
        setListOrientation(listOrientation != null ? listOrientation : ListOrientation.VERTICAL);

        final TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
        dividerDrawable = typedArray.getDrawable(0);
        typedArray.recycle();
    }

    public void setListOrientation(ListOrientation listOrientation) {
        if (listOrientation != null) {
            this.listOrientation = listOrientation;
        } else {
            throw new NullPointerException(context.getString(R.string.msgInvalidOrientation));
        }
    }

    @Override
    public void onDrawOver(Canvas canvas, RecyclerView parent, RecyclerView.State state) {
        if (listOrientation.equals(ListOrientation.VERTICAL)) {
            drawVertical(canvas, parent);
        } else {
            drawHorizontal(canvas, parent);
        }
    }

    private void drawVertical(Canvas canvas, RecyclerView parent) {
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + dividerDrawable.getIntrinsicHeight();
            dividerDrawable.setBounds(left, top, right, bottom);
            dividerDrawable.draw(canvas);
        }
    }

    private void drawHorizontal(Canvas canvas, RecyclerView parent) {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();

        final int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i++) {
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            final int left = child.getRight() + params.rightMargin;
            final int right = left + dividerDrawable.getIntrinsicHeight();
            dividerDrawable.setBounds(left, top, right, bottom);
            dividerDrawable.draw(canvas);
        }
    }
}