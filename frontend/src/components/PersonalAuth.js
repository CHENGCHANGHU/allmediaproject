import React from "react"
import { Form, Input, Button } from 'antd';
// import "./MyList.css"

const layout = {
  labelCol: { span: 8 },
  wrapperCol: { span: 10 },
};
const tailLayout = {
  wrapperCol: { offset: 8, span: 10 },
};

export default class PersonalAuth extends React.Component{

  render(){
    return (
      <div className="list4-wrapper list-wrapper">
        <div className="list4-information">
          
          <Form {...layout} name="basic">
            <p className="list4-title">平台信息</p>
            <Form.Item label="领域" name="list4-field">
              <Input />
            </Form.Item>

            <Form.Item label="名称" name="list4-name">
              <Input />
            </Form.Item>

            <Form.Item label="签名" name="list4-sign">
              <Input />
            </Form.Item>

            <p className="list4-title">运营者信息</p>
            <Form.Item label="姓名" name="list4-name1">
              <Input />
            </Form.Item>
            <Form.Item label="身份证" name="list4-idcard">
              <Input />
            </Form.Item>
            <Form.Item label="邮箱" name="list4-email">
              <Input />
            </Form.Item>
            <Form.Item label="所属公司" name="list4-company">
              <Input />
            </Form.Item>
            <Form.Item label="职务" name="list4-job">
              <Input />
            </Form.Item>

            <Form.Item {...tailLayout}>
              <Button type="primary" htmlType="submit">
                不通过
              </Button>
              <Button type="primary" htmlType="submit">
                通过
              </Button>
            </Form.Item>
          </Form>
        </div>
      </div>
    )
  }
}