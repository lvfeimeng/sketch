/*
 * Copyright (C) 2013 Peng fei Pan <sky@xiaopan.me>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.xiaopan.sketch.request;

import android.widget.ImageView.ScaleType;

import me.xiaopan.sketch.Sketch;
import me.xiaopan.sketch.SketchView;

public class ViewInfo {
    private ScaleType scaleType;
    private FixedSize fixedSize;
    private boolean hugeImageEnabled;

    public ViewInfo() {

    }

    public ViewInfo(ViewInfo viewInfo) {
        copy(viewInfo);
    }

    public void copy(ViewInfo viewInfo) {
        this.scaleType = viewInfo.scaleType;
        this.fixedSize = viewInfo.fixedSize;
        this.hugeImageEnabled = viewInfo.hugeImageEnabled;
    }

    public void reset(SketchView sketchView, Sketch sketch) {
        if (sketchView != null) {
            this.scaleType = sketchView.getScaleType();
            this.fixedSize = sketch.getConfiguration().getSizeCalculator().calculateImageFixedSize(sketchView);
            this.hugeImageEnabled = sketchView.isHugeImageEnabled();
        } else {
            this.scaleType = null;
            this.fixedSize = null;
            this.hugeImageEnabled = false;
        }
    }

    public FixedSize getFixedSize() {
        return fixedSize;
    }

    public ScaleType getScaleType() {
        return scaleType;
    }

    public boolean isHugeImageEnabled() {
        return hugeImageEnabled;
    }
}
