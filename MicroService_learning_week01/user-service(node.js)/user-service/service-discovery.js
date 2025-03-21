/*
 * @Descripttion:
 * @version:
 * @Author: Jason chen
 * @Date: 2021-08-27 11:22:32
 * @LastEditors: Jason chen
 * @LastEditTime: 2021-08-27 14:09:32
 */
// 注册服务到Nacos服务器
async function registerService() {
  const { NacosNamingClient } = require("nacos");

  const { address } = require("ip");
  // 动态获取本机 IP 地址
  const ipAddr = address();
  const port = 3001; // 当前应用的端口号
  const username = "nacos";
  const password = "nacos";
  const providerServiceName = "edsp-component-app1"; // 服务名称
  const nacosServerAddress = "localhost:8848"; // Nacos 服务地址
  const logger = console;
  const client = new NacosNamingClient({
    logger,
    serverList: nacosServerAddress,
    username: username,
    password: password,
    namespace: "public",
  });
  console.log("[Nacos] 注册Nacos服务");
  async () => {
    const allinstance = await client.getAllInstances();
    console.log("[Nacos]----allinstance----", allinstance);
  };
  (async () => {
    try {
      await client.ready();
      // 注册服务和实例
      await client.registerInstance(providerServiceName, {
        ip: ipAddr,
        port,
      });
      // 这里也可以传入group，不传默认就是 DEFAULT_GROUP
      // const groupName = 'nodejs';
      // await client.registerInstance(providerServiceName, {
      // ip: ipAddr,
      // port
      // }, groupName);
      console.log(`[Nacos] Nacos服务注册实例成功: ${ipAddr}:${port}`);
    } catch (err) {
      console.log("[Nacos] Nacos服务注册实例失败: " + err.toString());
    }
  })();
}
module.exports = registerService;
