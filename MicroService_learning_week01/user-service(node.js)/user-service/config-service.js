/*
 * @Descripttion:
 * @version:
 * @Author: Jason chen
 * @Date: 2021-08-27 10:05:04
 * @LastEditors: Jason chen
 * @LastEditTime: 2021-08-27 14:03:06
 */
// 注册配置,获取配置
const NacosConfigClient = require("nacos").NacosConfigClient;
// nacos服务地址
const nacosServerAddress = "localhost:8848";
// namespace: 名称空间必须在服务器上存在
const providerNamespase = "edsp-domain";
// 名称空间下的Group
const group = "DEFAULT_GROUP";
// 命名空间下的Data Id
const dataId = "test1";
const username = "nacos";
const password = "nacos";
// for direct mode
const configClient = new NacosConfigClient({
  serverAddr: nacosServerAddress,
  namespace: providerNamespase,
  username: username,
  password: password,
});

// 获取nacos配置
(async () => {
  const content1 = await configClient.getConfig(dataId, group);
  console.log("[Nacos] 获取配置： ", content1);
})();

// 监听远程nacos配置变化
configClient.subscribe(
  {
    dataId: dataId,
    group: group,
  },
  (content) => {
    console.log("[Nacos] 监听远程nacos配置:", content);
  }
);
