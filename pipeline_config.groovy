libraries {
  ansible {
    nodeLabel = "linux"
  }
  maven 
}

application_environments {
  dev {
    ip_addresses = ["192.168.1.111", "192.168.1.115"]
  }
  test {
    ip_addresses = ["10.0.2.111", "10.0.2.115"]
  }
}
