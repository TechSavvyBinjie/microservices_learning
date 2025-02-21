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

async function registerService() {
  try {
    // 等待客户端准备就绪
    await client.ready();
    console.log("[Nacos] 客户端已准备就绪");

    // 注册服务实例
    await client.registerInstance(providerServiceName, {
      ip: ipAddr,
      port,
    });
    console.log(`[Nacos] 服务实例注册成功: ${ipAddr}:${port}`);

    // 查询所有实例
    const allInstances = await client.getAllInstances(providerServiceName);
    console.log("[Nacos] 查询到的所有实例信息:", allInstances);
  } catch (err) {
    console.error("[Nacos] 服务注册失败:", err);
  }
}

// 导出 registerService 函数
module.exports = { registerService };
