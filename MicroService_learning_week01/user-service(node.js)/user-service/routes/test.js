const express = require("express");
const router = express.Router();

router.get("/test", (req, res) => {
  res.send("Hello nodejs and nacos");
});

module.exports = router;
