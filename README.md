# react-native-uking-fast-image

[![npm package](https://badge.fury.io/js/react-native-uking-fast-image.svg)](https://www.npmjs.com/package/react-native-uking-fast-image)
[![npm download](https://img.shields.io/npm/dm/react-native-uking-fast-image.svg?style=flat-square)](https://www.npmjs.com/package/react-native-uking-fast-image)

##Introduction

原生图片加载组件，，集成到 iOS 和 Android 。

原生图片加载组件是基于 

SDWebImage(IOS) GIT: https://github.com/rs/SDWebImage.git

Glide(android) GIT: https://github.com/bumptech/glide.git

##注：

如果有不对的地方请提交到issues以便解决。

##Installation

###npm or yarn 

npm install react-native-uking-fast-image  or yarn add react-native-uking-fast-image

##BarCode

![image](https://github.com/An-uking/react-native-uking-qrcode/blob/master/screenshots/2.jpg)

##QRCode

![image](https://github.com/An-uking/react-native-uking-qrcode/blob/master/screenshots/3.jpg)

![image](https://github.com/An-uking/react-native-uking-qrcode/blob/master/screenshots/4.jpg)

![image](https://github.com/An-uking/react-native-uking-qrcode/blob/master/screenshots/1.jpg)

###IOS:

在你的项目ios目录下面新建一个Profile文件:
```
    platform :ios, '8.0'
    target '你的项目名称' do
        pod 'yoga', path: '../node_modules/react-native/ReactCommon/yoga/'    
        pod 'React', :path => '../node_modules/react-native', :subspecs => [
            'Core',
            'DevSupport'
        ]
        pod 'RCTFastImageView', path: '../node_modules/react-native-uking-fast-image/ios/'
    end
```
然后在ios目录下 执行 pod install
然后把ios/Pods录下 Pods.xcodeproj添加到 Libraries下

3. 如果是 iOS 中请求图片为http请求,请在Info.plist中添加http请求权限: 


#### Android

make the following additions to the given files manually:

**android/settings.gradle**

```gradle
include ':react-native-uking-fast-image'
project(':react-native-uking-fast-image').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-uking-fast-image/android')
```

**android/app/build.gradle**

```gradle
dependencies {
    ...
    compile project(':react-native-uking-fast-image')
}
```

**MainApplication.java**

On top, where imports are:

```java
import net.muding.uking.rctfastimageview.RCTFastImageViewPackage;
```

Add the `RCTFastImageViewPackage` class to your list of exported packages.

```java
@Override
protected List<ReactPackage> getPackages() {
    return Arrays.asList(
            new MainReactPackage(),
            new RCTFastImageViewPackage()
    );
}
```


##Usage

```javascript
import FastImage from 'react-native-uking-fast-image';

<FastImage 
    src="url" 
    placeholder="占位图片" //占位图片 ios请添加占位图片到项目的资源管理里面，android请添加到你项目的drawable里，占位图片名称最好统一
    resizeMode="填充方式"
/>
```
