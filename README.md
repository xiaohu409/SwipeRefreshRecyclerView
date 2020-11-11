[![](https://jitpack.io/v/xiaohu409/SwipeRefreshRecyclerView.svg)](https://jitpack.io/#xiaohu409/SwipeRefreshRecyclerView)

# SwipeRefreshRecyclerView
### 概述 
 这是一个Android Library 带有下拉刷新和上拉加载更多的RecyclerView

### 截图
![效果图](device-2018-06-18-192510.png)

### 引用依赖库
```groovy
dependencies {
    implementation project(':swiperefreshrecycler')
    }
```

### 使用教程

1.在module的build.gradle引用依赖库
```groovy
dependencies {
    implementation project(':swiperefreshrecycler')
    }
```
2.在xml布局文件里使用SwipeRefreshRecyclerView控件
```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".SampleActivity">

    <com.github.xiaohu409.swiperefreshrecycler.widget.SwipeRefreshRecyclerView
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:id="@+id/swipe_refresh_recycler_view_id"/>
</android.support.constraint.ConstraintLayout>
```
3.在代码里实例化控件并设置回调、设置布局，绑定数据
```java
//实例化控件
SwipeRefreshRecyclerView recyclerView = findViewById(R.id.swipe_refresh_recycler_view_id);
//设置回调
recyclerView.setLoadDataCallback(new SwipeRefreshRecyclerView.LoadDataCallback() {
    @Override
    public void onPullDownData() {
        //todo 下拉刷新
    }

    @Override
    public void onPullUpData() {
        //todo 上拉加载
    }
});
//设置布局
recyclerView.setLayoutManager(new LinearLayoutManager(this));
//数据源
List<SampleBean.DataBean.NewsBean> newsBeanList = new ArrayList<>();
//实例化适配器
SampleAdapter sampleAdapter = new SampleAdapter(this, newsBeanList);
//设置适配器
recyclerView.setAdapter(sampleAdapter);
```

## Licens
Copyright 2018 xiaohu409

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
