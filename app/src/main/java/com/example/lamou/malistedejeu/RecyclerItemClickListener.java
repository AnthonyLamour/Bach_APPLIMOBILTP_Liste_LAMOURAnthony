package com.example.lamou.malistedejeu;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    //déclaration de la variable
        private OnItemClickListener mListener;

    //création de la fonction OnItemClickListener qui permet de récupérer la position de l'élément clické
        public interface OnItemClickListener
        {
            public void onItemClick(View view,int position);
        }

    //déclaration de variable
        GestureDetector mGestureDetector;

    //création de la fonction RecyclerItemClickListener permettant de définir si un item est clické
        public RecyclerItemClickListener(Context context, OnItemClickListener listener) {
            mListener = listener;
            mGestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
        }

    //création de la fonction onInterceptTouchEvent permettant de réaliser un traitement lorsqu'un item est clické
        @Override
        public boolean onInterceptTouchEvent(RecyclerView view, MotionEvent e) {
            View childView = view.findChildViewUnder(e.getX(), e.getY());
            if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
                mListener.onItemClick(childView, view.getChildAdapterPosition(childView));
            }
            return false;
        }

    @Override
    public
    void onTouchEvent(RecyclerView view, MotionEvent motionEvent) {
    }
    @Override
    public
    void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }
}
