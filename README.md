# android_learning_step_by_step
### 一、开始启程
了解Android全貌，搭建Android开发环境，准备测试机，创建Hello world项目。

了解项目资源，了解gradle文件。

初识Android四大组件：
Activity，Service，BroadCastReceiver，ContentProvider

### 二、Activity
####2.1 Activity的基本概念
####2.2 创建Activity
2.2.1 创建活动

2.2.2 学习Activity的布局加载

2.2.3 在AndroidManifest注册

2.2.4 学习使用Toast

2.2.5 学习在Activity中手动创建Menu

2.2.6 销毁Activity
####2.3 Intent的使用
2.3.1 显式Intent

利用构造函数Intent(Context packageContext, Class<?> cls)
两个参数，第一个提供上下文，第二个为目标Activity

`Intent intent = new Intent(MainActivity.this, SecActivity.class);
                   startActivity(intent);`

2.3.2 隐式Intent

2.3.3 通过Intent向下一个Activity传递数据

2.3.4 通过Intent向上一个Activity传递数据
