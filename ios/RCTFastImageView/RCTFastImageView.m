//
//  RCTFastImageView.m
//  RCTFastImageView
//
//  Created by uking on 2018/2/2.
//  Copyright © 2018年 uking. All rights reserved.
//

#import "RCTFastImageView.h"
#import "RCTConvert.h"
#import <UIKit/UIKit.h>
#import "UIImageView+WebCache.h"
#import "FLAnimatedImageView.h"

@implementation RCTConvert(RCTResizeMode)

RCT_ENUM_CONVERTER(RCTResizeMode, (@{
                                     @"cover": @(RCTResizeModeCover),
                                     @"contain": @(RCTResizeModeContain),
                                     @"stretch": @(RCTResizeModeStretch),
                                     @"center": @(RCTResizeModeCenter),
                                     }), RCTResizeModeStretch, integerValue)

@end

@implementation RCTFastImageView{
    FLAnimatedImageView *_image;
    NSString *_src;
    NSString *_resizeMode;
    NSString *_placeholder;
}
-(void) setSrc:(NSString *)src{
    _src=src;
    [self removeImage];
    
}
-(void)setPlaceholder:(NSString *)placeholder{
    _placeholder=placeholder;
    [self removeImage];
}
-(void) setResizeMode:(NSString *)resizeMode{
    
    _resizeMode = resizeMode;
    [self removeImage];
}

-(void) removeImage
{
    if (_image) {
        [_image removeFromSuperview];
    }
}
-(void)layoutSubviews
{
    [super layoutSubviews];
    _image= [[FLAnimatedImageView alloc] init];
    [_image sd_setImageWithURL:[NSURL URLWithString:_src] placeholderImage:[UIImage imageNamed:_placeholder]];
    _image.frame = self.bounds;
    _image.contentMode=(UIViewContentMode)[RCTConvert RCTResizeMode:_resizeMode];
    [self insertSubview:_image atIndex:0];
}
@end
