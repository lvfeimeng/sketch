/*
 * Copyright (C) 2017 Peng fei Pan <sky@xiaopan.me>
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

package me.xiaopan.sketch.uri;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;

import me.xiaopan.sketch.datasource.AssetsDataSource;
import me.xiaopan.sketch.datasource.DataSource;
import me.xiaopan.sketch.request.DownloadResult;

public class AssetUriModel extends UriModel {

    public static final String SCHEME = "asset://";

    public static String makeUri(String assetResName) {
        if (TextUtils.isEmpty(assetResName)) {
            return null;
        }
        return !assetResName.startsWith(SCHEME) ? SCHEME + assetResName : assetResName;
    }

    @Override
    protected boolean match(@NonNull String uri) {
        return !TextUtils.isEmpty(uri) && uri.startsWith(SCHEME);
    }

    /**
     * 获取 uri 所真正包含的内容部分，例如 "asset://test.png"，就会返回 "test.png"
     *
     * @param uri 图片 uri
     * @return uri 所真正包含的内容部分，例如 "asset://test.png"，就会返回 "test.png"
     */
    @Override
    public String getUriContent(@NonNull String uri) {
        return match(uri) ? uri.substring(SCHEME.length()) : uri;
    }

    @NonNull
    @Override
    public DataSource getDataSource(@NonNull Context context, @NonNull String uri, DownloadResult downloadResult) throws GetDataSourceException {
        return new AssetsDataSource(context, getUriContent(uri));
    }
}
