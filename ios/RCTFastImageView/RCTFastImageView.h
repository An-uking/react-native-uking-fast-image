//
//  RCTFastImageView.h
//  RCTFastImageView
//
//  Created by uking on 2018/2/2.
//  Copyright © 2018年 uking. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "RCTView.h"
typedef NS_ENUM(NSInteger, RCTResizeMode) {
    RCTResizeModeCover = UIViewContentModeScaleAspectFill,
    RCTResizeModeContain = UIViewContentModeScaleAspectFit,
    RCTResizeModeStretch = UIViewContentModeScaleToFill,
    RCTResizeModeCenter = UIViewContentModeCenter
};

@interface RCTFastImageView : RCTView
/**
 @text 图片url
 */
@property (nonatomic, copy) NSString *src;
/**
 @format 占位图片
 */
@property (nonatomic, copy) NSString *placeholder;
/**
 @format 填充模式
 */
@property (nonatomic, copy) NSString *resizeMode;
@end
