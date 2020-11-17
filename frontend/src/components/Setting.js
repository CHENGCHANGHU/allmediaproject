import React from "react"
import { Upload, message, Form ,Input, Button} from 'antd';
import { LoadingOutlined, PlusOutlined } from '@ant-design/icons';
// import "./MyList5.css"

const layout = {
  labelCol: { span: 8 },
  wrapperCol: { span: 10 },
};
const tailLayout = {
  wrapperCol: { offset: 8, span: 10 },
};

function getBase64(img, callback) {
  const reader = new FileReader();
  reader.addEventListener('load', () => callback(reader.result));
  reader.readAsDataURL(img);
}

function beforeUpload(file) {
  const isJpgOrPng = file.type === 'image/jpeg' || file.type === 'image/png';
  if (!isJpgOrPng) {
    message.error('You can only upload JPG/PNG file!');
  }
  const isLt2M = file.size / 1024 / 1024 < 2;
  if (!isLt2M) {
    message.error('Image must smaller than 2MB!');
  }
  return isJpgOrPng && isLt2M;
}

class Avatar extends React.Component {
  state = {
    loading: false,
  };

  handleChange = info => {
    if (info.file.status === 'uploading') {
      this.setState({ loading: true });
      return;
    }
    if (info.file.status === 'done') {
      // Get this url from response in real world.
      getBase64(info.file.originFileObj, imageUrl =>
        this.setState({
          imageUrl,
          loading: false,
        }),
      );
    }
  };

  render() {
    const uploadButton = (
      <div>
        {this.state.loading ? <LoadingOutlined /> : <PlusOutlined />}
        <div className="ant-upload-text">Upload</div>
      </div>
    );
    const { imageUrl } = this.state;
    return (
      <Upload
        name="avatar"
        listType="picture-card"
        className="avatar-uploader"
        showUploadList={false}
        action="https://www.mocky.io/v2/5cc8019d300000980a055e76"
        beforeUpload={beforeUpload}
        onChange={this.handleChange}
      >
        {imageUrl ? <img src={imageUrl} alt="avatar" style={{ width: '100%' }} /> : uploadButton}
      </Upload>
    );
  }
}

export default class Setting extends React.Component{
  render(){
    return (
      <div className="list5-wrapper list-wrapper">
        <div className="list5-setting">设置</div>
        <div className="list5-information">
          <Form {...layout} name="basic">
            <Form.Item label="头像" name="list5-image">
              <Avatar />
            </Form.Item>
            <Form.Item label="姓名" name="list5-name">
              <Input />
            </Form.Item>
            <Form.Item label="性别" name="list5-gender">
              <Input />
            </Form.Item>
            <Form.Item label="姓名" name="list5-n1">
              <Input />
            </Form.Item>
            <Form.Item label="..." name="list5-n2">
              <Input />
            </Form.Item>
            <Form.Item label="..." name="list5-n3">
              <Input />
            </Form.Item>
            <Form.Item label="..." name="list5-n4">
              <Input />
            </Form.Item>
            <Form.Item label="..." name="list5-n5">
              <Input />
            </Form.Item>
            <Form.Item {...tailLayout}>
              <Button type="primary" htmlType="submit">
                保存
              </Button>
            </Form.Item>
          </Form>
        </div>
      </div>
    )
  }
}

