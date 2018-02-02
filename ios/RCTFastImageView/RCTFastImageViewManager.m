//
//  RCTFastImageViewManager.m
//  RCTFastImageView
//
//  Created by uking on 2018/2/2.
//  Copyright © 2018年 uking. All rights reserved.
//

#import "RCTFastImageView.h"
#import "RCTFastImageViewManager.h"
@implementation RCTFastImageViewManager
RCT_EXPORT_MODULE()
- (UIView *)view
{
    return [[RCTFastImageView alloc] init];
}
RCT_EXPORT_VIEW_PROPERTY(src, NSString);
RCT_EXPORT_VIEW_PROPERTY(placeholder, NSString);
RCT_EXPORT_VIEW_PROPERTY(resizeMode, NSString);
@end
