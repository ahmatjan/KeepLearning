// TextView.h : interface of the CTextView class
//
/////////////////////////////////////////////////////////////////////////////

#if !defined(AFX_TEXTVIEW_H__23B45D9E_2550_49CB_9276_3B5FCE1E1C71__INCLUDED_)
#define AFX_TEXTVIEW_H__23B45D9E_2550_49CB_9276_3B5FCE1E1C71__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000


class CTextView : public CView
{
protected: // create from serialization only
	CTextView();
	DECLARE_DYNCREATE(CTextView)

// Attributes
public:
	CTextDoc* GetDocument();

// Operations
public:

// Overrides
	// ClassWizard generated virtual function overrides
	//{{AFX_VIRTUAL(CTextView)
	public:
	virtual void OnDraw(CDC* pDC);  // overridden to draw this view
	virtual BOOL PreCreateWindow(CREATESTRUCT& cs);
	protected:
	virtual BOOL OnPreparePrinting(CPrintInfo* pInfo);
	virtual void OnBeginPrinting(CDC* pDC, CPrintInfo* pInfo);
	virtual void OnEndPrinting(CDC* pDC, CPrintInfo* pInfo);
	//}}AFX_VIRTUAL

// Implementation
public:
	virtual ~CTextView();
#ifdef _DEBUG
	virtual void AssertValid() const;
	virtual void Dump(CDumpContext& dc) const;
#endif

protected:

// Generated message map functions
protected:
	//{{AFX_MSG(CTextView)
	afx_msg void OnLButtonDown(UINT nFlags, CPoint point);
	afx_msg int OnCreate(LPCREATESTRUCT lpCreateStruct);
	afx_msg void OnChar(UINT nChar, UINT nRepCnt, UINT nFlags);
	//}}AFX_MSG
	DECLARE_MESSAGE_MAP()
private:
	CString m_strLine;
	CPoint m_ptOrigin;
};

#ifndef _DEBUG  // debug version in TextView.cpp
inline CTextDoc* CTextView::GetDocument()
   { return (CTextDoc*)m_pDocument; }
#endif

/////////////////////////////////////////////////////////////////////////////

//{{AFX_INSERT_LOCATION}}
// Microsoft Visual C++ will insert additional declarations immediately before the previous line.

#endif // !defined(AFX_TEXTVIEW_H__23B45D9E_2550_49CB_9276_3B5FCE1E1C71__INCLUDED_)
