#include <windows.h>
#include "resource.h"

const char g_szClassName[] = "myWindowsClass";
HBITMAP g_hbmBall = NULL;

LRESULT CALLBACK WndProc(HWND hwnd, UINT msg, WPARAM wParam, LPARAM lParam)
{
	switch(msg)
	{
		case WM_CREATE:
			g_hbmBall = LoadBitmap(GetModuleHandle(NULL), MAKEINTRESOURCE(IDB_BALL));
			if (g_hbmBall == NULL)
				MessageBox(hwnd, "Could not load IDB_BALL", "Error", MB_OK | MB_ICONEXCLAMATION);
			break;
		case WM_PAINT:
		{
			BITMAP bm;
			PAINTSTRUCT ps;
			HDC hdc = BeginPaint(hwnd, &ps);
			HDC hdcMem = CreateCompatibleDC(hdc);
			HBITMAP hbmOld = SelectObject(hdcMem, g_hbmBall);

			GetObject(g_hbmBall, sizeof(bm), &bm);

			BitBlt(hdc, 0, 0, bm.bmWidth, bm.bmHeight, hdcMem, 0, 0, SRCCOPY);

			SelectObject(hdcMem, hbmOld);
			DeleteDC(hdcMem);
			EndPaint(hwnd, &ps);

			break;
		}
		case WM_CLOSE:
			DestroyWindow(hwnd);
			break;
		case WM_DESTROY:
			PostQuitMessage(0);
			break;
		default:
			return DefWindowProc(hwnd, msg, wParam, lParam);
	}
	return 0;
}

int WINAPI WinMain(HINSTANCE hInstance, HINSTANCE hPrevInstance,
		LPSTR lpCmdLine, int nCmdShow)
{
	WNDCLASSEX wc;
	HWND hwnd;
	MSG Msg;

	//Step 1: Registering the Window Class
	wc.cbSize = sizeof(WNDCLASSEX);
	wc.style = 0;
	wc.lpfnWndProc = WndProc;
	wc.cbClsExtra = 0;
	wc.cbWndExtra = 0;
	wc.hInstance = hInstance;
	wc.hIcon = LoadIcon(NULL, IDI_APPLICATION);
	wc.hCursor = LoadCursor(NULL, IDC_ARROW);
	wc.hbrBackground = (HBRUSH)(COLOR_WINDOW + 1);
	wc.lpszMenuName = NULL;
	wc.lpszClassName = g_szClassName;
	wc.hIconSm = LoadIcon(NULL, IDI_APPLICATION);
	if (!RegisterClassEx(&wc))
	{
		MessageBox(NULL, "Window Registration Failed!",
				"Error!", MB_ICONEXCLAMATION | MB_OK);
		return 0;
	}

	//Step 2: Creation the Window
	hwnd = CreateWindowEx(
			WS_EX_CLIENTEDGE,
			g_szClassName,
			"The title of my window",
			WS_OVERLAPPEDWINDOW,
			CW_USEDEFAULT, CW_USEDEFAULT,
			600, 300,
			NULL, NULL,
			hInstance, NULL);
	if (hwnd == NULL)
	{
		MessageBox(NULL, "Window Creation Failed!", 
				"Error!", MB_ICONEXCLAMATION | MB_OK);
		return 0;
	}

	ShowWindow(hwnd, nCmdShow);
	UpdateWindow(hwnd);

	//Step 3: The Message Loop
	while (GetMessage(&Msg, NULL, 0, 0) > 0)
	{
		TranslateMessage(&Msg);
		DispatchMessage(&Msg);
	}
	return Msg.wParam;
}
