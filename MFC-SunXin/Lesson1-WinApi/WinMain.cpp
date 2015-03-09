#include <windows.h>
#include <stdio.h>

LRESULT CALLBACK WindowProc(
  HWND hwnd,      // handle to window
  UINT uMsg,      // message identifier
  WPARAM wParam,  // first message parameter
  LPARAM lParam   // second message parameter
);

int WINAPI WinMain(
  HINSTANCE hInstance,      // handle to current instance
  HINSTANCE hPrevInstance,  // handle to previous instance
  LPSTR lpCmdLine,          // command line
  int nCmdShow              // show state
)
{
	WNDCLASS wndcls;

	wndcls.cbClsExtra = 0;
	wndcls.cbWndExtra = 0;
	wndcls.hbrBackground = (HBRUSH)GetStockObject(BLACK_BRUSH);
	wndcls.hCursor = LoadCursor(NULL, IDC_CROSS);
	wndcls.hIcon = LoadIcon(NULL, IDI_ERROR);
	wndcls.hInstance = hInstance;
	wndcls.lpfnWndProc = WindowProc;
	wndcls.lpszClassName = "test";
	wndcls.lpszMenuName = NULL;
	wndcls.style = CS_HREDRAW | CS_VREDRAW;
	RegisterClass(&wndcls);

	HWND hwnd;
	hwnd = CreateWindow("test", "���Ǹ���˧��", WS_OVERLAPPEDWINDOW,
		0, 0, 600, 400, NULL, NULL, hInstance,NULL);

	ShowWindow(hwnd, SW_SHOWNORMAL);
	UpdateWindow(hwnd);

	MSG msg;
	while(GetMessage(&msg, NULL, 0, 0))
	{
		TranslateMessage(&msg);
		DispatchMessage(&msg);
	}

	return 0;
}

LRESULT CALLBACK WindowProc(
  HWND hwnd,      // handle to window
  UINT uMsg,      // message identifier
  WPARAM wParam,  // first message parameter
  LPARAM lParam   // second message parameter
)
{
	switch(uMsg)
	{
	case WM_CHAR:
		char szChar[20];
		sprintf(szChar, "char is %d", wParam);
		MessageBox(hwnd, szChar, "����˧������", 0);
		break;
	case WM_LBUTTONDOWN:
		MessageBox(hwnd, "mouse clicked.", "��ܴ��������", 0);
		HDC hdc1;
		hdc1 = GetDC(hwnd);
		TextOut(hdc1, 0, 50, "������", strlen("������"));
		ReleaseDC(hwnd, hdc1);
		break;
	case WM_PAINT:
		HDC hdc2;
		PAINTSTRUCT ps;
		hdc2 = BeginPaint(hwnd, &ps);
		TextOut(hdc2, 0, 0, "��Ļ���·�ˢ", strlen("��Ļ���·�ˢ"));
		EndPaint(hwnd, &ps);
		break;
	case WM_CLOSE:
		if(IDYES == MessageBox(hwnd, "�Ƿ���Ľ�����", "���Ǹ���ţ��ر���ʾ", MB_YESNO))
		{
			DestroyWindow(hwnd);
		}
		break;
	case WM_DESTROY:
	    PostQuitMessage(0);
		break;
	default:
		return DefWindowProc(hwnd, uMsg, wParam, lParam);
	}

	return 0;
}