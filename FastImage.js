import { PropTypes } from 'prop-types';
import React,{Component } from 'react';
import { requireNativeComponent,View } from 'react-native';

class FastImage extends Component{
    static propTypes={
        ...View.propTypes,
        src: PropTypes.string.isRequired,
        resizeMode:PropTypes.oneOf(['contain', 'stretch', 'center', 'cover']).isRequired,
        placeholder:PropTypes.string
    }
    static defaultProps={
        placeholder:'goods_placeholder',
        resizeMode:'stretch'
    };
    constructor(props,content){
        super(props,content)

    }
    render(){
        console.log(this.props)
        return(
            <RCTFastImageView {...this.props} />
        )
    }
}
const RCTFastImageView=requireNativeComponent('RCTFastImageView', FastImage);
module.exports = FastImage