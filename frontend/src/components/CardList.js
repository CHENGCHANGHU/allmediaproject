import React from "react";
import { List, Avatar, Tag, Card } from "antd";
// import "./CardList.css";

const data = [
  {
    title: "用户名",
  },
];

export default class CardList extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      display: false,
    };
  }

  handleDisplay = () => {
    this.setState({
      display: true,
    });
  };

  componentDidMount() {
    //必须在这里声明，所以 ref 回调可以引用它
    // this.props.onRef(this);
  }

  render() {
    return (
      <div
        className={
          this.state.display ? "list6-wrapper displayed" : "list6-wrapper"
        }
      >
        <List
          itemLayout="horizontal"
          dataSource={data}
          renderItem={(item) => (
            <List.Item>
              <List.Item.Meta
                avatar={
                  <Avatar src="https://zos.alipayobjects.com/rmsportal/ODTLcjxAfvqbxHnVXCYX.png" />
                }
                title={item.title}
              />
            </List.Item>
          )}
        />

        <Tag>Tag 1</Tag>

        <Card style={{ width: 220 }}>
          <p>基本信息</p>
          <p>基本信息</p>
        </Card>
      </div>
    );
  }
}
