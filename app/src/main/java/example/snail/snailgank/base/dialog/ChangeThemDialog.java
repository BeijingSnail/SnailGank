package example.snail.snailgank.base.dialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import example.snail.snailgank.R;

import static example.snail.snailgank.R.id.amber_cv;
import static example.snail.snailgank.R.id.blue_cv;
import static example.snail.snailgank.R.id.brown_cv;
import static example.snail.snailgank.R.id.cyan_cv;
import static example.snail.snailgank.R.id.deep_orange_cv;
import static example.snail.snailgank.R.id.deep_purple_cv;
import static example.snail.snailgank.R.id.green_cv;
import static example.snail.snailgank.R.id.grey_blue_cv;
import static example.snail.snailgank.R.id.grey_cv;
import static example.snail.snailgank.R.id.indigo_cv;
import static example.snail.snailgank.R.id.light_blue_cv;
import static example.snail.snailgank.R.id.light_green_cv;
import static example.snail.snailgank.R.id.lime_cv;
import static example.snail.snailgank.R.id.orange_cv;
import static example.snail.snailgank.R.id.pick_cv;
import static example.snail.snailgank.R.id.purple_cv;
import static example.snail.snailgank.R.id.red_cv;
import static example.snail.snailgank.R.id.teal_cv;
import static example.snail.snailgank.R.id.yellow_cv;

/**
 * 更换主题的dialog
 * Created by Snial on 2017/5/27.
 */

public class ChangeThemDialog extends Dialog {

    public ChangeThemDialog(Context context) {
        super(context);
    }

    public ChangeThemDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static class Builder {
        private Context mContext;

        private OnSelectClickListener mOnSelectClickListener;

        public interface OnSelectClickListener {
            void selectClick(View view, int them);
        }

        public void setOnSelectClickListener(OnSelectClickListener onSelectClickListener) {
            this.mOnSelectClickListener = onSelectClickListener;
        }

        public Builder(Context context) {
            this.mContext = context;
        }

        public ChangeThemDialog creat() {
            ChangeThemDialog dialog = new ChangeThemDialog(mContext, R.style.dialog);
            View view = LayoutInflater.from(mContext).inflate(R.layout.dialog_skin_layout, null);
            dialog.addContentView(view, new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            initView(view);
            return dialog;
        }

        private void initView(View view) {
            CardView redCv = (CardView) view.findViewById(red_cv);
            CardView pickCv = (CardView) view.findViewById(pick_cv);
            CardView purpleCv = (CardView) view.findViewById(purple_cv);
            CardView deepPurpleCv = (CardView) view.findViewById(deep_purple_cv);
            CardView indigoCv = (CardView) view.findViewById(indigo_cv);
            CardView blueCv = (CardView) view.findViewById(blue_cv);
            CardView lightBlueCv = (CardView) view.findViewById(light_blue_cv);
            CardView cyanCv = (CardView) view.findViewById(cyan_cv);
            CardView tealCv = (CardView) view.findViewById(teal_cv);
            CardView greenCv = (CardView) view.findViewById(green_cv);
            CardView lightGreenCv = (CardView) view.findViewById(light_green_cv);
            CardView limeCv = (CardView) view.findViewById(lime_cv);
            CardView yellowCv = (CardView) view.findViewById(yellow_cv);
            CardView amberCv = (CardView) view.findViewById(amber_cv);
            CardView orangeCv = (CardView) view.findViewById(orange_cv);
            CardView deepOrangeCv = (CardView) view.findViewById(deep_orange_cv);
            CardView brownCv = (CardView) view.findViewById(brown_cv);
            CardView greyCv = (CardView) view.findViewById(grey_cv);
            CardView greyBlueCv = (CardView) view.findViewById(grey_blue_cv);

            if (redCv != null && mOnSelectClickListener != null) {
                redCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(redCv, R.style.RedTheme));
            }
            if (pickCv != null && mOnSelectClickListener != null) {
                pickCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(pickCv, R.style.PickTheme));
            }
            if (purpleCv != null && mOnSelectClickListener != null) {
                purpleCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(purpleCv, R.style.PurpleTheme));
            }
            if (deepPurpleCv != null && mOnSelectClickListener != null) {
                deepPurpleCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(deepPurpleCv, R.style.DeepPurpleTheme));
            }
            if (indigoCv != null && mOnSelectClickListener != null) {
                indigoCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(indigoCv, R.style.IndigoTheme));
            }
            if (blueCv != null && mOnSelectClickListener != null) {
                blueCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(blueCv, R.style.BlueTheme));
            }
            if (lightBlueCv != null && mOnSelectClickListener != null) {
                lightBlueCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(lightBlueCv, R.style.LightBlueTheme));
            }
            if (cyanCv != null && mOnSelectClickListener != null) {
                cyanCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(cyanCv, R.style.CyanTheme));
            }
            if (tealCv != null && mOnSelectClickListener != null) {
                tealCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(tealCv, R.style.TealTheme));
            }
            if (greenCv != null && mOnSelectClickListener != null) {
                greenCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(greenCv, R.style.GreenTheme));
            }
            if (lightGreenCv != null && mOnSelectClickListener != null) {
                lightGreenCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(lightGreenCv, R.style.LightGreenTheme));
            }
            if (limeCv != null && mOnSelectClickListener != null) {
                limeCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(limeCv, R.style.LimeTheme));
            }
            if (yellowCv != null && mOnSelectClickListener != null) {
                yellowCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(yellowCv, R.style.YellowTheme));
            }
            if (amberCv != null && mOnSelectClickListener != null) {
                amberCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(amberCv, R.style.AmberTheme));
            }
            if (orangeCv != null && mOnSelectClickListener != null) {
                orangeCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(orangeCv, R.style.OrangeTheme));
            }
            if (deepOrangeCv != null && mOnSelectClickListener != null) {
                deepOrangeCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(deepOrangeCv, R.style.DeepOrangeTheme));
            }
            if (brownCv != null && mOnSelectClickListener != null) {
                brownCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(brownCv, R.style.BrownTheme));
            }
            if (greyCv != null && mOnSelectClickListener != null) {
                greyCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(greyCv, R.style.GreyTheme));
            }
            if (greyBlueCv != null && mOnSelectClickListener != null) {
                greyBlueCv.setOnClickListener(v -> mOnSelectClickListener.selectClick(greyBlueCv, R.style.GreyBlueTheme));
            }

        }
    }
}
