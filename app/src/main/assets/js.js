
// ネイティブ側に通知
function notificationToNative(val) {
  const isIOS = /[ \(]iP/.test(navigator.userAgent)
  if (isIOS) {
    // iOS側に通知
    webkit.messageHandlers.callbackHandler.postMessage(val);
  } else {
    // Android側に通知
    alert(val);
  };
}

// ネイティブ側からjavascriptを実行
function changeDisplay(val) {
  var label = document.getElementById("label");
  label.textContent = val;
}

// WebViewのメニューボタンタップ時
function tappedMenuButton() {
  // ネイティブ側に通知
  notificationToNative("tappedMenuButton()");
}
